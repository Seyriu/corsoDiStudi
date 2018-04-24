/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class VotoDTO {

  long idVoto;
  int valutazione, semestre, annoSemestre;
  String materia;
  LocalDate dataVoto;

  public VotoDTO() {
  }

  public VotoDTO(long idVoto, int valutazione, int semestre, int annoSemestre, String Materia, LocalDate dataVoto) {
    this.idVoto = idVoto;
    this.valutazione = valutazione;
    this.semestre = semestre;
    this.annoSemestre = annoSemestre;
    this.materia = Materia;
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

  public int getSemestre() {
    return semestre;
  }

  public void setSemestre(int semestre) {
    this.semestre = semestre;
  }

  public int getAnnoSemestre() {
    return annoSemestre;
  }

  public void setAnnoSemestre(int annoSemestre) {
    this.annoSemestre = annoSemestre;
  }

  public String getMateria() {
    return materia;
  }

  public void setMateria(String Materia) {
    this.materia = Materia;
  }

  public LocalDate getDataVoto() {
    return dataVoto;
  }

  public void setDataVoto(LocalDate dataVoto) {
    this.dataVoto = dataVoto;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + (int) (this.idVoto ^ (this.idVoto >>> 32));
    hash = 29 * hash + this.valutazione;
    hash = 29 * hash + this.semestre;
    hash = 29 * hash + this.annoSemestre;
    hash = 29 * hash + Objects.hashCode(this.materia);
    hash = 29 * hash + Objects.hashCode(this.dataVoto);
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
    if (this.valutazione != other.valutazione) {
      return false;
    }
    if (this.semestre != other.semestre) {
      return false;
    }
    if (this.annoSemestre != other.annoSemestre) {
      return false;
    }
    if (!Objects.equals(this.materia, other.materia)) {
      return false;
    }
    if (!Objects.equals(this.dataVoto, other.dataVoto)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "VotoDTO{" + "idVoto=" + idVoto + ", valutazione=" + valutazione + ", semestre=" + semestre + ", annoSemestre=" + annoSemestre + ", Materia=" + materia + ", dataVoto=" + dataVoto + '}';
  }

  

}
