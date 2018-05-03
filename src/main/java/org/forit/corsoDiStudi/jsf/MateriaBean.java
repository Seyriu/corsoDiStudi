/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
@ManagedBean(name = "mBean")
@ViewScoped
public class MateriaBean {
  
  private Map<Long, String> materie = new HashMap<>();

  @PostConstruct
  private void init() {
    this.loadMaterie();
  }

  public Set<Long> getIdMaterie() {
    return materie.keySet();
  }

  public String getDescrizioneById(Long id) {
    return materie.get(id);
  }

  public long getIdByDescrizione(String descrizione) {
    return materie.entrySet().stream()
            .filter(entry -> entry.getValue().equals(descrizione))
            .findAny().get().getKey();
  }
  
  private void loadMaterie() {
    try {
      CorsoDiStudiDAO netflixDAO = new CorsoDiStudiDAO();
      materie = netflixDAO.getListaMaterie();
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
      materie = new HashMap<>();
    }
  }
}
