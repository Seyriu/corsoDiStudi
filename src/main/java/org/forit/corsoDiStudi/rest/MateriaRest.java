/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.rest;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.MateriaDAO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
@Path("/materie")
public class MateriaRest {

  @Path("/")
  @GET
  @Produces("application/json")
  public Map<Long, String> loadMaterie() {
//    CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
//    try {
//      return cds.getListaMaterie();
//    } catch (CDSException ex) {
//      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
//      return new HashMap<>();
//    }
    MateriaDAO mdao = new MateriaDAO();
    return mdao.getListaMaterie();
  }

  @Path("/{id}")
  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public String loadMateria(@PathParam("id") Long id) {
      MateriaDAO mdao = new MateriaDAO();
      return mdao.getMateria(id);
  }

  @Path("/{id}")
  @PUT
  @Consumes("application/json")
  @Produces("application/json")
  public boolean updateMateria(String nome, @PathParam("id") Long id) {
    try {
      MateriaDAO mdao = new MateriaDAO();
      mdao.updateMateria(id, nome);
      return true;
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
      return false;
    }
  }
  
  @Path("/")
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public boolean insertMateria(String nome) {
    try {
      MateriaDAO mdao = new MateriaDAO();
      mdao.insertMateria(nome);
      return true;
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
      return false;
    }
  }
  
  @Path("/{id}")
  @DELETE
  @Consumes("application/json")
  @Produces("application/json")
  public boolean deleteMateria(@PathParam("id") Long id) {
    try {
      MateriaDAO mdao = new MateriaDAO();
      mdao.deleteMateria(id);
      return true;
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
      return false;
    }
  }
}
