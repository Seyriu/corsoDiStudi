/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
@Path("/voti")
public class VotoRest {
  
  
  @Path("/")
  @GET
  @Produces("application/json")
  public List<VotoDTO> loadVoti() {
    CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
    try {
      return cds.getListaVoti();
    } catch (CDSException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      return new ArrayList<>();
    }
  }
  
}
