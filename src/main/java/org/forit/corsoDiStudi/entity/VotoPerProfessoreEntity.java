/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Utente
 */
@Embeddable
public class VotoPerProfessoreEntity implements Serializable {

  @ManyToOne
  @JoinColumn(name = "ID_VOTI")
  private VotoEntity votoEntity;

  public VotoPerProfessoreEntity() {
  }

  public VotoPerProfessoreEntity(VotoEntity votoEntity) {
    this.votoEntity = votoEntity;
  }

  public VotoEntity getVotoEntity() {
    return votoEntity;
  }

  public void setVotoEntity(VotoEntity votoEntity) {
    this.votoEntity = votoEntity;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.votoEntity);
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
    final VotoPerProfessoreEntity other = (VotoPerProfessoreEntity) obj;
    if (!Objects.equals(this.votoEntity, other.votoEntity)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "VotoPerProfessoreEntity{" + "votoEntity=" + votoEntity + '}';
  }
}
