/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.rest;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.forit.corsoDiStudi.dao.ClasseDAO;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dto.ClasseDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author UTENTE
 */

    @Path("/classi")
public class ClasseRest {

    @Path("/")
    @GET()
    @Produces("application/json")
    public Map<Long, String> getClasse() {
//        NetflixDAO netflixDAO= new NetflixDAO();
//        try{
//            return netflixDAO.getListaNazioni();
//        }catch (NetflixException ex){
//            return new HashMap<>();
//        
//        }
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.getListaClassi();
    }

    @Path("/{id}")
    @GET()
    @Produces("application/json")
    public String getClasse(@PathParam("id") long ID) {
//        return this.getNazioni().get(ID);
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.getClasse(ID);
    }
    @Path("/")
    @POST()
    
    @Produces("application/json")
    public String postClasse(@PathParam("id") long ID){
        
             ClasseDAO classeDAO= new ClasseDAO();
             return classeDAO.getClasse(ID);
      
    }
}

