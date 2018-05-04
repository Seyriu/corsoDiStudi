/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

import java.util.Objects;

/**
 *
 * @author UTENTE
 */
public class ClasseDTO {

  private long id;
  private String nome;

  public ClasseDTO() {
  }

  public ClasseDTO(long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 47 * hash + Objects.hashCode(this.nome);
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
    final ClasseDTO other = (ClasseDTO) obj;
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
    return "ClasseDTO{" + "id=" + id + ", nome=" + nome + '}';
  }

}
