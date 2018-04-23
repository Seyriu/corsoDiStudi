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
public class ProfessoreDTO {

  private String nome, cognome, email;
  private long id;

  public ProfessoreDTO() {
  }

  public ProfessoreDTO(String nome, String cognome, String email, long id) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.id = id;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 17 * hash + Objects.hashCode(this.nome);
    hash = 17 * hash + Objects.hashCode(this.cognome);
    hash = 17 * hash + Objects.hashCode(this.email);
    hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
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
    final ProfessoreDTO other = (ProfessoreDTO) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    if (!Objects.equals(this.cognome, other.cognome)) {
      return false;
    }
    if (!Objects.equals(this.email, other.email)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ProfessoreDTO{" + "nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", id=" + id + '}';
  }  

}
