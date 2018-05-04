/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author UTENTE
 */
@Entity
@Table(name = "professore")
@NamedQueries({
  @NamedQuery(name = "professore.selectAll", query = "SELECT n FROM ProfessoreEntity n ORDER BY n.nome")

})
public class ProfessoreEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  private long ID = -1;

  @Column(name = "NOME", unique = false, nullable = false)
  private String nome;

  @Column(name = "COGNOME", unique = false, nullable = false)
  private String cognome;

  @Column(name = "MAIL", unique = false, nullable = false)
  private String mail;

  @ElementCollection()
  @CollectionTable(name = "materia_x_prof", joinColumns = @JoinColumn(name = "id_prof"))
  private List<MateriaPerProfessoreEntity> materie = new ArrayList<>();

  @ElementCollection()
  @CollectionTable(name = "voto_x_prof", joinColumns = @JoinColumn(name = "id_prof"))
  private List<VotoPerProfessoreEntity> voti = new ArrayList<>();

  public ProfessoreEntity() {
  }

  public ProfessoreEntity(String nome, String cognome, String mail) {
    this.nome = nome;
    this.cognome = cognome;
    this.mail = mail;
  }

  public long getID() {
    return ID;
  }

  public void setID(long ID) {
    this.ID = ID;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public List<MateriaPerProfessoreEntity> getMaterie() {
    return materie;
  }

  public void setMaterie(List<MateriaPerProfessoreEntity> materie) {
    this.materie = materie;
  }

  public List<VotoPerProfessoreEntity> getVoti() {
    return voti;
  }

  public void setVoti(List<VotoPerProfessoreEntity> voti) {
    this.voti = voti;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 79 * hash + (int) (this.ID ^ (this.ID >>> 32));
    hash = 79 * hash + Objects.hashCode(this.nome);
    hash = 79 * hash + Objects.hashCode(this.cognome);
    hash = 79 * hash + Objects.hashCode(this.mail);
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
    final ProfessoreEntity other = (ProfessoreEntity) obj;
    if (this.ID != other.ID) {
      return false;
    }
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    if (!Objects.equals(this.cognome, other.cognome)) {
      return false;
    }
    if (!Objects.equals(this.mail, other.mail)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ProfessoreEntity{" + "ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + '}';
  }

}
