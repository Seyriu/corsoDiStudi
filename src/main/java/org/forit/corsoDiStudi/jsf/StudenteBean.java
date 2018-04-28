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
import javax.faces.bean.ViewScoped;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dto.StudenteDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
@ManagedBean
@ViewScoped
public class StudenteBean {

  List<StudenteDTO> studenti = new ArrayList<>();
  StudenteDTO studente = new StudenteDTO(-1, "", "", LocalDate.now(), "", "", "");
  private boolean disabled;

  @PostConstruct
  private void init() {
    this.loadStudenti();
  }

  private void loadStudenti() {
    CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
    try {
      studenti = cds.getListaStudenti();
    } catch (CDSException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      studenti = new ArrayList<>();
    }
  }

  public void loadStudente(long id, boolean disabled) {
    this.disabled = disabled;
    if (id == -1) {
      studente = new StudenteDTO(-1, "", "", LocalDate.now(), "", "", "");
    } else {
      try {
        CorsoDiStudiDAO studenteDAO = new CorsoDiStudiDAO();
        studente = studenteDAO.getStudente(id);
      } catch (CDSException ex) {
        System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
        studente = new StudenteDTO(-1, "", "", LocalDate.now(), "", "", "");
      }
    }
  }

  public void saveStudente() {
    try {
      CorsoDiStudiDAO cds = new CorsoDiStudiDAO();
      if (studente.getId() == -1) {
        cds.insertStudente(studente);
      } else {
        cds.updateStudente(studente);
      }
      this.loadStudenti();
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore: " + ex.getLocalizedMessage());
    }
  }

  public List<StudenteDTO> getStudenti() {
    return studenti;
  }

  public void setStudenti(List<StudenteDTO> studenti) {
    this.studenti = studenti;
  }

  public StudenteDTO getStudente() {
    return studente;
  }

  public void setStudente(StudenteDTO studente) {
    this.studente = studente;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }
}
