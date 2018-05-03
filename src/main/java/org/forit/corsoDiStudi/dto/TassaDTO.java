/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author UTENTE
 */
public class TassaDTO {

  private long id;
  private String isee;
  BigDecimal costo;

  public TassaDTO() {
  }

  public TassaDTO(long id, String isee, BigDecimal costo) {
    this.id = id;
    this.isee = isee;
    this.costo = costo;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getIsee() {
    return isee;
  }

  public void setIsee(String isee) {
    this.isee = isee;
  }

  public BigDecimal getCosto() {
    return costo;
  }

  public void setCosto(BigDecimal costo) {
    this.costo = costo;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 29 * hash + Objects.hashCode(this.isee);
    hash = 29 * hash + Objects.hashCode(this.costo);
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
    final TassaDTO other = (TassaDTO) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.isee, other.isee)) {
      return false;
    }
    if (!Objects.equals(this.costo, other.costo)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "TasseDTO{" + "id=" + id + ", isee=" + isee + ", costo=" + costo + '}';
  }

}
