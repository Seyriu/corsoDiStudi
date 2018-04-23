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
public class TasseDTO {
      private long id;
    private String isee, costo;

    public TasseDTO() {
    }

    public TasseDTO(long id, String isee, String costo) {
        this.id = id;
        this.isee = isee;
        this.costo = costo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsee() {
        return isee;
    }

    public void setIsee(String isee) {
        this.isee = isee;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.isee);
        hash = 29 * hash + Objects.hashCode(this.costo);
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
        final TasseDTO other = (TasseDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.isee, other.isee)) {
            return false;
        }
        if (!Objects.equals(this.costo, other.costo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TasseDTO{" + "id=" + id + ", isee=" + isee + ", costo=" + costo + '}';
    }
    
    
}
