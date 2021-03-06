/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Utente
 */
public class ProfessoreDTO {

    private long id;
    private String nome, cognome, email;
    
    private List<MateriaDTO> materia=new ArrayList<>();
    
    private List<VotoDTO> voti=new ArrayList<>();
    private List<StudenteDTO> studente=new ArrayList<>();

    public ProfessoreDTO() {
    }

    public ProfessoreDTO(long id, String nome, String cognome, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<MateriaDTO> getMateria() {
    return materia;
  }

  public void setMateria(List<MateriaDTO> materia) {
    this.materia = materia;
  }

  public List<VotoDTO> getVoti() {
    return voti;
  }

  public void setVoti(List<VotoDTO> voti) {
    this.voti = voti;
  }

  public List<StudenteDTO> getStudente() {
    return studente;
  }

  public void setStudente(List<StudenteDTO> studente) {
    this.studente = studente;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 11 * hash + Objects.hashCode(this.nome);
    hash = 11 * hash + Objects.hashCode(this.cognome);
    hash = 11 * hash + Objects.hashCode(this.email);
    hash = 11 * hash + Objects.hashCode(this.materia);
    hash = 11 * hash + Objects.hashCode(this.voti);
    hash = 11 * hash + Objects.hashCode(this.studente);
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
    if (!Objects.equals(this.materia, other.materia)) {
      return false;
    }
    if (!Objects.equals(this.voti, other.voti)) {
      return false;
    }
    if (!Objects.equals(this.studente, other.studente)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ProfessoreDTO{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", materia=" + materia + ", voti=" + voti + ", studente=" + studente + '}';
  }

}