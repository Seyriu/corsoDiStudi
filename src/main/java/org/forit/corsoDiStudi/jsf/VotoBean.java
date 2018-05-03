/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.jsf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
@ManagedBean
@ViewScoped
public class VotoBean {

  private VotoDTO voto = new VotoDTO(0, 0, 0, 0, LocalDate.now());
  private List<VotoDTO> voti = new ArrayList<>();
  private boolean disabled;
  long idMateria;

  @ManagedProperty(value = "#{mBean}")
  private MateriaBean materia;

  @PostConstruct
  private void init() {
  }

//
//  public void loadStudente(long id, boolean disabled) {
//    this.disabled = disabled;
//    if (id == -1) {
//      studente = new StudenteDTO(-1, "", "", LocalDate.now(), "", "", "");
//    } else {
//      try {
//        CorsoDiStudiDAO studenteDAO = new CorsoDiStudiDAO();
//        studente = studenteDAO.getStudente(id);
//      } catch (CDSException ex) {
//        System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
//        studente = new StudenteDTO(-1, "", "", LocalDate.now(), "", "", "");
//      }
//    }
//  }
//
  public void saveVoto() {
    try {
      CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
      if (voto.getIdVoto() == -1) {
//        cds.insertStudente(studente);
      } else {
        cds.updateVoto(voto.getIdVoto(), this.idMateria, voto.getDataVoto(), voto.getValutazione());
      }
      // studenteBean.loadStudenti();
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
    }
  }

  public VotoDTO getVoto() {
    return voto;
  }

  public void setVoto(VotoDTO voto) {
    this.voto = voto;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public MateriaBean getMateria() {
    return materia;
  }

  public void setMateria(MateriaBean materia) {
    this.materia = materia;
  }

  public List<VotoDTO> getVoti() {
    return voti;
  }

  public void setVoti(List<VotoDTO> voti) {
    this.voti = voti;
  }

  public long getIdMateria() {
    return idMateria;
  }

  public void setIdMateria(long idMateria) {
    this.idMateria = idMateria;
  }

}
