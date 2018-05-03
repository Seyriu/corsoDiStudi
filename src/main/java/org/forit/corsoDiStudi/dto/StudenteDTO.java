/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudenteDTO {
    private long id;
    private String nome, cognome;
    private LocalDate dataNascita;
    private String codiceFiscale;
    private String matricola;
    private String mail;
    
    private List<TasseDTO> tasse = new ArrayList<>();
    private List<VotoDTO> voti = new ArrayList<>();

    public StudenteDTO() {
    }

    public StudenteDTO(long id, String nome, String cognome, LocalDate dataNascita, String codiceFiscale, String matricola, String mail) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.codiceFiscale = codiceFiscale;
        this.matricola = matricola;
        this.mail = mail;
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
    
    public String getDataNascitaAsString() {
      return dataNascita.toString();
    }
    
    public String getDataNascitaAsFormattedString() {
      return dataNascita.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDataNascitaAsString(String dataNascita) {
      this.dataNascita = LocalDate.parse(dataNascita);
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

  public List<TasseDTO> getTasse() {
    return tasse;
  }

  public void setTasse(List<TasseDTO> tasse) {
    this.tasse = tasse;
  }

  public List<VotoDTO> getVoti() {
    return voti;
  }

  public void setVoti(List<VotoDTO> voti) {
    this.voti = voti;
  }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.cognome);
        hash = 23 * hash + Objects.hashCode(this.dataNascita);
        hash = 23 * hash + Objects.hashCode(this.codiceFiscale);
        hash = 23 * hash + Objects.hashCode(this.matricola);
        hash = 23 * hash + Objects.hashCode(this.mail);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.codiceFiscale, other.codiceFiscale)) {
            return false;
        }
        if (!Objects.equals(this.matricola, other.matricola)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.dataNascita, other.dataNascita)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentiDTO{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", codiceFiscale=" + codiceFiscale + ", matricola=" + matricola + ", mail=" + mail + ", tasse=" + tasse + ", voti=" + voti + '}';
    }

}
