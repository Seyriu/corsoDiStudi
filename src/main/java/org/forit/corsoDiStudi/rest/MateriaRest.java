/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
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
    CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
    try {
      return cds.getListaMaterie();
    } catch (CDSException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      return new HashMap<>();
    }
  }
  
  
}
