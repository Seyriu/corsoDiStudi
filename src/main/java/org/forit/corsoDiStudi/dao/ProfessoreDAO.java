/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.forit.corsoDiStudi.dto.MateriaDTO;
import org.forit.corsoDiStudi.dto.ProfessoreDTO;
import org.forit.corsoDiStudi.entity.MateriaEntity;
import org.forit.corsoDiStudi.entity.MateriaPerProfessoreEntity;
import org.forit.corsoDiStudi.entity.ProfessoreEntity;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author UTENTE
 */
public class ProfessoreDAO {

    public ProfessoreDTO getProfessore(long ID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em = emf.createEntityManager();

        ProfessoreEntity entity = em.find(ProfessoreEntity.class, ID);

        ProfessoreDTO professore = new ProfessoreDTO(entity.getID(), entity.getNome(), entity.getCognome(),
                entity.getMail());

        List<MateriaDTO> materie = entity.getMaterie().stream().map(abbEntity -> {
            return new MateriaDTO(
                    abbEntity.getMateriaEntity().getId(),
                    abbEntity.getMateriaEntity().getNome());
        }).collect(Collectors.toList());

        professore.setMateria(materie);

        em.close();
        emf.close();

        return professore;
    }

    public List<ProfessoreDTO> getListaProfessori() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<ProfessoreEntity> query = em.createNamedQuery("professore.selectAll", ProfessoreEntity.class);
        List<ProfessoreEntity> list = query.getResultList();
        List<ProfessoreDTO> professori = list.stream().map(entity -> {
            ProfessoreDTO professore = new ProfessoreDTO(entity.getID(), entity.getNome(), entity.getCognome(),
                    entity.getMail());

            List<MateriaDTO> materie = entity.getMaterie().stream().map(abbEntity -> {
                return new MateriaDTO(
                        abbEntity.getMateriaEntity().getId(),
                        abbEntity.getMateriaEntity().getNome()
                );
            }).collect(Collectors.toList());

            professore.setMateria(materie);
            return professore;
        }).collect(Collectors.toList());

        em.close();
        emf.close();

        return professori;
    }

    public boolean insertProfessore(ProfessoreDTO professore) throws CDSException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            ProfessoreEntity entity = new ProfessoreEntity();
            entity.setNome(professore.getNome());
            entity.setCognome(professore.getCognome());
            entity.setMail(professore.getEmail());

            List<MateriaPerProfessoreEntity> list = professore.getMateria().stream().
                    map(materia -> em.find(MateriaEntity.class, materia.getId())).
                    map(me -> new MateriaPerProfessoreEntity(me)).
                    collect(Collectors.toList());
            
            entity.setMaterie(list);
            em.persist(entity);

            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            throw new CDSException(ex);
        } finally {
            em.close();
            emf.close();
        }
    }
}
