/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class VotoDTO {

  long idVoto, idStudente, idMateria;
  int valutazione;
  LocalDate dataVoto;

  List<ProfessoreDTO> professori;

  public List<ProfessoreDTO> getProfessori() {
    return professori;
  }

  public void setProfessori(List<ProfessoreDTO> professori) {
    this.professori = professori;
  }

  public VotoDTO() {
  }

  public VotoDTO(long idVoto, long idStudente, long idMateria, int valutazione, LocalDate dataVoto) {
    this.idVoto = idVoto;
    this.idStudente = idStudente;
    this.idMateria = idMateria;
    this.valutazione = valutazione;
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

  public LocalDate getDataVoto() {
    return dataVoto;
  }

  public void setDataVoto(LocalDate dataVoto) {
    this.dataVoto = dataVoto;
  }

  public String getDataVotoAsString() {
    return dataVoto.toString();
  }

  public void setDataVotoAsString(String dataNascita) {
    this.dataVoto = LocalDate.parse(dataNascita);
  }

  public long getIdStudente() {
    return idStudente;
  }

  public void setIdStudente(long idStudente) {
    this.idStudente = idStudente;
  }

  public long getIdMateria() {
    return idMateria;
  }

  public void setIdMateria(long idMateria) {
    this.idMateria = idMateria;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 23 * hash + (int) (this.idVoto ^ (this.idVoto >>> 32));
    hash = 23 * hash + (int) (this.idStudente ^ (this.idStudente >>> 32));
    hash = 23 * hash + (int) (this.idMateria ^ (this.idMateria >>> 32));
    hash = 23 * hash + this.valutazione;
    hash = 23 * hash + Objects.hashCode(this.dataVoto);
    hash = 23 * hash + Objects.hashCode(this.professori);
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
    if (this.idStudente != other.idStudente) {
      return false;
    }
    if (this.idMateria != other.idMateria) {
      return false;
    }
    if (this.valutazione != other.valutazione) {
      return false;
    }
    if (!Objects.equals(this.dataVoto, other.dataVoto)) {
      return false;
    }
    if (!Objects.equals(this.professori, other.professori)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "VotoDTO{" + "idVoto=" + idVoto + ", idStudente=" + idStudente + ", idMateria=" + idMateria + ", valutazione=" + valutazione + ", dataVoto=" + dataVoto + ", professori=" + professori + '}';
  }
}
