/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

/**
 *
 * @author Utente
 */
public class StudenteDTO {

  private long id;
  private String nome, cognome, dataNascita, email, cf, matricola, tasse, classe;

  public StudenteDTO() {
  }

  public StudenteDTO(long id, String nome, String cognome, String dataNascita, String email, String cf, String matricola, String tasse, String classe) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.dataNascita = dataNascita;
    this.email = email;
    this.cf = cf;
    this.matricola = matricola;
    this.tasse = tasse;
    this.classe = classe;
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

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getDataNascita() {
    return dataNascita;
  }

  public void setDataNascita(String dataNascita) {
    this.dataNascita = dataNascita;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCf() {
    return cf;
  }

  public void setCf(String cf) {
    this.cf = cf;
  }

  public String getMatricola() {
    return matricola;
  }

  public void setMatricola(String matricola) {
    this.matricola = matricola;
  }

  public String getTasse() {
    return tasse;
  }

  public void setTasse(String tasse) {
    this.tasse = tasse;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
    final StudenteDTO other = (StudenteDTO) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "StudenteDTO{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", email=" + email + ", cf=" + cf + ", matricola=" + matricola + ", tasse=" + tasse + ", classe=" + classe + '}';
  }
  
  
}
