/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.forit.corsoDiStudi.entity.MateriaEntity;

/**
 *
 * @author UTENTE
 */
@Embeddable
public class MateriaPerProfessoreEntity implements Serializable{

    @ManyToOne
    @JoinColumn(name = "ID_MATERIA")
    private MateriaEntity materiaEntity;

    public MateriaPerProfessoreEntity() {
    }

    public MateriaPerProfessoreEntity(MateriaEntity materiaEntity) {
        this.materiaEntity = materiaEntity;
    }

    public MateriaEntity getMateriaEntity() {
        return materiaEntity;
    }

    public void setMateriaEntity(MateriaEntity materiaEntity) {
        this.materiaEntity = materiaEntity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.materiaEntity);
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
        final MateriaPerProfessoreEntity other = (MateriaPerProfessoreEntity) obj;
        if (!Objects.equals(this.materiaEntity, other.materiaEntity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MateriaPerProfessoreEntity{" + "materiaEntity=" + materiaEntity + '}';
    }
    
    
    
}
