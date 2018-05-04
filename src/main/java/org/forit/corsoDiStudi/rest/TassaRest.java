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
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.MateriaDAO;
import org.forit.corsoDiStudi.dao.TassaDAO;
import org.forit.corsoDiStudi.dto.TassaDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
@Path("/tasse")
public class TassaRest {
  
  @Path("/")
  @GET
  @Produces("application/json")
  public List<TassaDTO> loadTasse() {
    TassaDAO tdao = new TassaDAO();
    return tdao.getListaTasse();
  }
  
  @Path("/")
  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public boolean insertTassa(TassaDTO tassa) {
    try {
      TassaDAO tdao = new TassaDAO();
      tdao.insertTassa(tassa);
      return true;
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
      return false;
    }
  }
}
