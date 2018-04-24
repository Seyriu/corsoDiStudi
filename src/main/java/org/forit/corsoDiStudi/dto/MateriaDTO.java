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
public class MateriaDTO {
    private long id;
    private String nome;

    public MateriaDTO() {
    }

    public MateriaDTO(long id, String nome, String cognome) {
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
    int hash = 3;
    hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 23 * hash + Objects.hashCode(this.nome);
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
    final MateriaDTO other = (MateriaDTO) obj;
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
        return "MateriaDTO{" + "id=" + id + ", nome=" + nome +  '}';
    }
 
    
}
