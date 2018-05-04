/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Utente
 */
@Entity
@Table(name = "classe")
@NamedQueries({
  @NamedQuery(name = "classe.selectAll",
          query = "SELECT c from ClasseEntity c")
})
public class ClasseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // id e' generato automaticamente. Identity = campo autoincrementante
  @Column(name = "ID", unique = true, nullable = false)
  private long id;

  @Column(name = "NOME", unique = false, nullable = true)
  private String nome;

  @OneToMany(mappedBy = "classe")
  private List<StudenteEntity> studente;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<StudenteEntity> getStudente() {
    return studente;
  }

  public void setStudente(List<StudenteEntity> studente) {
    this.studente = studente;
  }
  
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 59 * hash + Objects.hashCode(this.nome);
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
    final ClasseEntity other = (ClasseEntity) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ClasseEntity{" + "id=" + id + ", nome=" + nome + '}';
  }

}
