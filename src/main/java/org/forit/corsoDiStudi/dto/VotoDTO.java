/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

import java.time.LocalDate;

/**
 *
 * @author Utente
 */
public class VotoDTO {
  long idVoto;
  int valutazione, idSemestre, idMateria, idStudente, idProf;
  LocalDate dataVoto;

  public VotoDTO() {
  }

  public VotoDTO(long idVoto, int valutazione, int idSemestre, int idMateria, int idStudente, int idProf, LocalDate dataVoto) {
    this.idVoto = idVoto;
    this.valutazione = valutazione;
    this.idSemestre = idSemestre;
    this.idMateria = idMateria;
    this.idStudente = idStudente;
    this.idProf = idProf;
    this.dataVoto = dataVoto;
  }

  public long getIdVoto() {
    return idVoto;
  }

  public void setIdVoto(long idVoto) {
    this.idVoto = idVoto;
  }

  public int getValutazione() {
    return valutazione;
  }

  public void setValutazione(int valutazione) {
    this.valutazione = valutazione;
  }

  public int getIdSemestre() {
    return idSemestre;
  }

  public void setIdSemestre(int idSemestre) {
    this.idSemestre = idSemestre;
  }

  public int getIdMateria() {
    return idMateria;
  }

  public void setIdMateria(int idMateria) {
    this.idMateria = idMateria;
  }

  public int getIdStudente() {
    return idStudente;
  }

  public void setIdStudente(int idStudente) {
    this.idStudente = idStudente;
  }

  public int getIdProf() {
    return idProf;
  }

  public void setIdProf(int idProf) {
    this.idProf = idProf;
  }

  public LocalDate getDataVoto() {
    return dataVoto;
  }

  public void setDataVoto(LocalDate dataVoto) {
    this.dataVoto = dataVoto;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 79 * hash + (int) (this.idVoto ^ (this.idVoto >>> 32));
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final VotoDTO other = (VotoDTO) obj;
    if (this.idVoto != other.idVoto) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "VotoDTO{" + "idVoto=" + idVoto + ", valutazione=" + valutazione + ", idSemestre=" + idSemestre + ", idMateria=" + idMateria + ", idStudente=" + idStudente + ", idProf=" + idProf + ", dataVoto=" + dataVoto + '}';
  }
  
}
