/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dao.ProfessoreDAO;
import org.forit.corsoDiStudi.dto.ProfessoreDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author UTENTE
 */
@Path("/professori")
public class ProfessoreRest {

    @Path("/")
    @GET()
    @Produces("application/json")
    public List<ProfessoreDTO> getProfessori() {
        ProfessoreDAO utenteDAO = new ProfessoreDAO();
        return utenteDAO.getListaProfessori();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public ProfessoreDTO getProfessore(@PathParam("id") long ID) {
        ProfessoreDAO professoreDAO = new ProfessoreDAO();
        return professoreDAO.getProfessore(ID);
    }

    @Path("/")
    @POST()
    @Consumes("application/json")
    @Produces("application/json")
    public boolean postProfessore(ProfessoreDTO professore) {
        try {
//            CorsoDiStudiDAO cdsDAO = new CorsoDiStudiDAO();
//            cdsDAO.insertProfessore(professore.getNome(), professore.getCognome(), professore.getMail());
            ProfessoreDAO professoreDAO = new ProfessoreDAO();
            professoreDAO.insertProfessore(professore);
            return true;
        } catch (CDSException ex) {
            System.out.println("ERRORE " + ex.getMessage());
            return false;
        }
    }
}
