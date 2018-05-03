/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Utente
 */
@Entity
@Table(name = "tassa")
@NamedQueries({
  @NamedQuery(name = "tassa.selectAll",
          query = "SELECT t from TassaEntity t Order by t.isee")
})
public class TassaEntity implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // id e' generato automaticamente. Identity = campo autoincrementante
  @Column(name = "ID", unique = true, nullable = false)
  private long id;

  @Column(name = "ISEE", unique = false, nullable = true)
  private String isee;

  @Column(name = "COSTO", unique = false, nullable = true)
  private BigDecimal costo;

  public TassaEntity() {
  }

  public TassaEntity(long id, String isee, BigDecimal costo) {
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
    int hash = 7;
    hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 59 * hash + Objects.hashCode(this.isee);
    hash = 59 * hash + Objects.hashCode(this.costo);
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
    final TassaEntity other = (TassaEntity) obj;
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
    return "TassaEntity{" + "id=" + id + ", isee=" + isee + ", costo=" + costo + '}';
  }
  
}
