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
import org.forit.corsoDiStudi.dto.TassaDTO;
import org.forit.corsoDiStudi.entity.MateriaEntity;
import org.forit.corsoDiStudi.entity.TassaEntity;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
public class TassaDAO {

  public List<TassaDTO> getListaTasse() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
    EntityManager em = emf.createEntityManager();
    TypedQuery<TassaEntity> query = em.createNamedQuery("tassa.selectAll", TassaEntity.class);
    List<TassaEntity> list = query.getResultList();
    List<TassaDTO> tasse = list.stream().
            map(entity -> {
              return new TassaDTO(
                      entity.getId(),
                      entity.getIsee(),
                      entity.getCosto()
              );
            }).collect(Collectors.toList());
    em.close();
    emf.close();

    return tasse;
  }

  public String getMateria(long id) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
    EntityManager em = emf.createEntityManager();

    MateriaEntity materia = em.find(MateriaEntity.class, id);
    String nome = materia.getNome();

    em.close();
    emf.close();

    return nome;
  }

  public void insertTassa(TassaDTO tassa) throws CDSException {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
    EntityManager em = emf.createEntityManager();

    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();

      TassaEntity tEntity = new TassaEntity();
      tEntity.setIsee(tassa.getIsee());
      tEntity.setCosto(tassa.getCosto());

      em.persist(tEntity);
      transaction.commit();
    } catch (Exception ex) {
      transaction.rollback();
      throw new CDSException(ex);
    } finally {
      em.close();
      emf.close();
    }
  }

  public void updateMateria(long id, String nome) throws CDSException {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
    EntityManager em = emf.createEntityManager();

    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();

//      NazioneEntity nazione = new NazioneEntity();
//      nazione.setId(id);
//      nazione.setDescrizione(descrizione);
//      em.persist(nazione); // fa la update se l'id esiste. Se l'id non esiste ed e' positivo, la persist fa la insert
      MateriaEntity materia = em.find(MateriaEntity.class, id);
      materia.setNome(nome);
      em.merge(materia); // la merge va sempre in update e aggiorna solo i campi richiesti

      em.persist(materia);
      transaction.commit();
    } catch (Exception ex) {
      transaction.rollback();
      throw new CDSException(ex);
    } finally {
      em.close();
      emf.close();
    }
  }

  public void deleteMateria(long id) throws CDSException {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
    EntityManager em = emf.createEntityManager();

    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();

      MateriaEntity materia = em.find(MateriaEntity.class, id);
      em.remove(materia);

      em.persist(materia);
      transaction.commit();
    } catch (Exception ex) {
      transaction.rollback();
      throw new CDSException(ex);
    } finally {
      em.close();
      emf.close();
    }
  }
}
