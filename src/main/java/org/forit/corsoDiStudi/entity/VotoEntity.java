/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "voto")
@NamedQueries({
  @NamedQuery(name = "voto.selectAll",
          query = "SELECT v from VotoEntity v")
})
public class VotoEntity implements Serializable{
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // id e' generato automaticamente. Identity = campo autoincrementante
  @Column(name = "ID", unique = true, nullable = false)
  private long id;

  @Column(name = "VALUTAZIONE", unique = false, nullable = true)
  private int valutazione;
  
  @Column(name = "DATA", unique = false, nullable = false)
  private LocalDate dataVoto;

  @Column(name = "ID_MATERIA", unique = false, nullable = true)
  private long idMateria;

  @Column(name = "ID_STUDENTE", unique = false, nullable = true)
  private long idStudente;

  public VotoEntity() {
  }
  
  public VotoEntity(long id, int valutazione, LocalDate dataVoto, long idMateria, long idStudente) {
    this.id = id;
    this.valutazione = valutazione;
    this.dataVoto = dataVoto;
    this.idMateria = idMateria;
    this.idStudente = idStudente;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public long getIdMateria() {
    return idMateria;
  }

  public void setIdMateria(long idMateria) {
    this.idMateria = idMateria;
  }

  public long getIdStudente() {
    return idStudente;
  }

  public void setIdStudente(long idStudente) {
    this.idStudente = idStudente;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 13 * hash + this.valutazione;
    hash = 13 * hash + Objects.hashCode(this.dataVoto);
    hash = 13 * hash + (int) (this.idMateria ^ (this.idMateria >>> 32));
    hash = 13 * hash + (int) (this.idStudente ^ (this.idStudente >>> 32));
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
    final VotoEntity other = (VotoEntity) obj;
    if (this.id != other.id) {
      return false;
    }
    if (this.valutazione != other.valutazione) {
      return false;
    }
    if (this.idMateria != other.idMateria) {
      return false;
    }
    if (this.idStudente != other.idStudente) {
      return false;
    }
    if (!Objects.equals(this.dataVoto, other.dataVoto)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "VotoEntity{" + "id=" + id + ", valutazione=" + valutazione + ", dataVoto=" + dataVoto + ", idMateria=" + idMateria + ", idStudente=" + idStudente + '}';
  }
}
