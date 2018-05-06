/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.forit.corsoDiStudi.dto.StudenteDTO;
import org.forit.corsoDiStudi.dto.TassaDTO;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.entity.ClasseEntity;
import org.forit.corsoDiStudi.entity.StudenteEntity;
import org.forit.corsoDiStudi.entity.TassaEntity;
import org.forit.corsoDiStudi.entity.VotoEntity;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
public class StudenteDAO {

    public StudenteDTO loadStudente(long id) throws CDSException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            StudenteEntity studente = em.find(StudenteEntity.class, id);
            String nome = studente.getNome();
            String cognome = studente.getCognome();
            LocalDate dataNascita = studente.getDataNascita();
            String mail = studente.getMail();
            String codiceFiscale = studente.getCodiceFiscale();
            String matricola = studente.getMatricola();

            ClasseEntity classe = studente.getClasse();
            String nomeClasse = classe == null ? "" : classe.getNome();

            StudenteDTO sdto = new StudenteDTO(
                    id,
                    nome,
                    cognome,
                    mail,
                    matricola,
                    dataNascita,
                    codiceFiscale,
                    nomeClasse
            );

            TassaEntity tassa = studente.getTassa();
            TassaDTO tdto = new TassaDTO(tassa.getId(), tassa.getIsee(), tassa.getCosto());
            sdto.setTassa(tdto);

            List<VotoEntity> votiStudente = studente.getVotiStudente();
            VotoDAO vdao = new VotoDAO();
            List<VotoDTO> votiDTO = vdao.getListaVotiDTOFromListaVotiEntita(votiStudente);
            sdto.setVoti(votiDTO);

            transaction.commit();

            return sdto;
        } catch (Exception ex) {
            transaction.rollback();
            throw new CDSException(ex);
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<StudenteDTO> loadStudenti() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
        EntityManager em = emf.createEntityManager();
        TypedQuery<StudenteEntity> query = em.createNamedQuery("studente.selectAll", StudenteEntity.class);
        List<StudenteEntity> list = query.getResultList();
        List<StudenteDTO> studente = list.stream().
                map(entity -> {
                    ClasseEntity classe = entity.getClasse();
                    String nomeClasse = classe == null ? "" : classe.getNome();

                    return new StudenteDTO(
                            entity.getId(),
                            entity.getNome(),
                            entity.getCognome(),
                            entity.getMail(),
                            entity.getMatricola(),
                            entity.getDataNascita(),
                            entity.getCodiceFiscale(),
                            nomeClasse
                    );
                }).collect(Collectors.toList());
        em.close();
        emf.close();

        return studente;
    }
}
