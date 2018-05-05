/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.VotoDAO;
import org.forit.corsoDiStudi.dto.VotoDTO;

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
        VotoDAO vdao = new VotoDAO();
        return vdao.getListaVoti();
    }

}
