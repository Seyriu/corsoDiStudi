/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dao.StudenteDAO;
import org.forit.corsoDiStudi.dto.StudenteDTO;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
@Path("/studenti")
public class StudenteRest {

    @Path("/")
    @GET
    @Produces("application/json")
    public List<StudenteDTO> loadStudenti() {
        StudenteDAO sdao = new StudenteDAO();
        return sdao.loadStudenti();
    }

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public StudenteDTO loadStudente(@PathParam("id") long id) {
        StudenteDAO cds = new StudenteDAO();
        try {
            return cds.loadStudente(id);
        } catch (CDSException ex) {
            System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
        }
        return null;
    }

    @Path("/")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public boolean insertStudente(StudenteDTO studente) {
        try {
            StudenteDAO sdao = new StudenteDAO();
            sdao.insertStudente(studente);
            return true;
        } catch (CDSException ex) {
            System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
            return false;
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public boolean updateStudente(StudenteDTO studente, @PathParam("id") Long id) {
        try {
            studente.setId(id);
            CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
            cds.updateStudente(studente);
            return true;
        } catch (CDSException ex) {
            System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
            return false;
        }
    }

    @Path("/{id}/voti/")
    @GET
    @Produces("application/json")
    public List<VotoDTO> loadVotiOfStudente(@PathParam("id") long idStudente) {
        CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
        try {
            return cds.getVotiFromIdStudente(idStudente);
        } catch (CDSException ex) {
            System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    @Path("/{id}/voti/{idVoto}/")
    @PUT
    @Produces("application/json")
    public void updateVoto(VotoDTO voto, @PathParam("idVoto") long idVoto) {
        try {
            CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
            cds.updateVoto(idVoto, voto.getIdMateria(), voto.getDataVoto(), voto.getValutazione());
        } catch (CDSException ex) {
            System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
        }
    }

//  public void insertVoto() {
//    try {
//      CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
//      if (voto.getIdVoto() == -1) {
////        cds.insertStudente(studente);
//      } else {
//        cds.updateVoto(voto.getIdVoto(), this.idMateria, voto.getDataVoto(), voto.getValutazione());
//      }
//      // studenteBean.loadStudenti();
//    } catch (CDSException ex) {
//      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
//    }
//  }
}
