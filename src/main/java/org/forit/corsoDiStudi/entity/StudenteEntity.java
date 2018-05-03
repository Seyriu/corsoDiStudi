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
@Table(name = "studente")
@NamedQueries({
  @NamedQuery(name = "studente.selectAll",
          query = "SELECT s from StudenteEntity s Order by s.cognome")
})
public class StudenteEntity implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // id e' generato automaticamente. Identity = campo autoincrementante
  @Column(name = "ID", unique = true, nullable = false)
  private long id;

  @Column(name = "NOME", unique = false, nullable = true)
  private String nome;

  @Column(name = "COGNOME", unique = false, nullable = true)
  private String cognome;

  @Column(name = "data_di_nascita", unique = false, nullable = false)
  private LocalDate dataNascita;

  @Column(name = "MAIL", unique = false, nullable = true)
  private String mail;

  @Column(name = "CODICE_FISCALE", unique = false, nullable = true)
  private String codiceFiscale;

  @Column(name = "MATRICOLA", unique = false, nullable = true)
  private String matricola;

  @Column(name = "ID_TASSA", unique = false, nullable = true)
  private String idTassa;

  @Column(name = "ID_CLASSE", unique = false, nullable = true)
  private String idClasse;

  public StudenteEntity() {
  }

  public StudenteEntity(long id, String nome, String cognome, LocalDate dataNascita, String mail, String codiceFiscale, String matricola, String idTassa, String idClasse) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.dataNascita = dataNascita;
    this.mail = mail;
    this.codiceFiscale = codiceFiscale;
    this.matricola = matricola;
    this.idTassa = idTassa;
    this.idClasse = idClasse;
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

  public LocalDate getDataNascita() {
    return dataNascita;
  }

  public void setDataNascita(LocalDate dataNascita) {
    this.dataNascita = dataNascita;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public String getMatricola() {
    return matricola;
  }

  public void setMatricola(String matricola) {
    this.matricola = matricola;
  }

  public String getIdTassa() {
    return idTassa;
  }

  public void setIdTassa(String idTassa) {
    this.idTassa = idTassa;
  }

  public String getIdClasse() {
    return idClasse;
  }

  public void setIdClasse(String idClasse) {
    this.idClasse = idClasse;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
    hash = 31 * hash + Objects.hashCode(this.nome);
    hash = 31 * hash + Objects.hashCode(this.cognome);
    hash = 31 * hash + Objects.hashCode(this.dataNascita);
    hash = 31 * hash + Objects.hashCode(this.mail);
    hash = 31 * hash + Objects.hashCode(this.codiceFiscale);
    hash = 31 * hash + Objects.hashCode(this.matricola);
    hash = 31 * hash + Objects.hashCode(this.idTassa);
    hash = 31 * hash + Objects.hashCode(this.idClasse);
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
    final StudenteEntity other = (StudenteEntity) obj;
    if (this.id != other.id) {
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
    if (!Objects.equals(this.codiceFiscale, other.codiceFiscale)) {
      return false;
    }
    if (!Objects.equals(this.matricola, other.matricola)) {
      return false;
    }
    if (!Objects.equals(this.idTassa, other.idTassa)) {
      return false;
    }
    if (!Objects.equals(this.idClasse, other.idClasse)) {
      return false;
    }
    if (!Objects.equals(this.dataNascita, other.dataNascita)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "StudenteEntity{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", mail=" + mail + ", codiceFiscale=" + codiceFiscale + ", matricola=" + matricola + ", idTassa=" + idTassa + ", idClasse=" + idClasse + '}';
  }
  
}
