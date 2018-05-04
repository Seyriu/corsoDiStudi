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
import javax.persistence.Persistence;
import org.forit.corsoDiStudi.dto.StudenteDTO;
import org.forit.corsoDiStudi.dto.TassaDTO;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.entity.ClasseEntity;
import org.forit.corsoDiStudi.entity.StudenteEntity;
import org.forit.corsoDiStudi.entity.TassaEntity;
import org.forit.corsoDiStudi.entity.VotoEntity;

/**
 *
 * @author Utente
 */
public class StudenteDAO {

  public StudenteDTO loadStudente(long id) {
//            Connection conn = DriverManager.getConnection(DB_URL);
//            PreparedStatement ps1 = conn.prepareStatement(STUDENTE);
//            PreparedStatement ps2 = conn.prepareStatement(TASSE_X_STUDENTE);
//            PreparedStatement ps3 = conn.prepareStatement(VOTI_X_STUDENTE)

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
    EntityManager em = emf.createEntityManager();

    StudenteEntity studente = em.find(StudenteEntity.class, id);
    String nome = studente.getNome();
    String cognome = studente.getCognome();
    LocalDate dataNascita = studente.getDataNascita();
    String mail = studente.getMail();
    String codiceFiscale = studente.getCodiceFiscale();
    String matricola = studente.getMatricola();

    ClasseEntity classe = studente.getClasse();

    StudenteDTO sdto = new StudenteDTO(id, nome, cognome,mail, matricola, dataNascita, codiceFiscale, classe.getNome());

    TassaEntity tassa = studente.getTassa();
    TassaDTO tdto = new TassaDTO(tassa.getId(), tassa.getIsee(), tassa.getCosto());
    sdto.setTassa(tdto);

    List<VotoEntity> votiStudente = studente.getVotiStudente();
    List<VotoDTO> votiDTO = votiStudente.stream().
            map(entity -> {
              return new VotoDTO(
                      entity.getId(),
                      studente.getId(),
                      entity.getIdMateria(),
                      entity.getValutazione(),
                      entity.getDataVoto()
              );
            }).collect(Collectors.toList());
    sdto.setVoti(votiDTO);

    em.close();
    emf.close();
    return sdto;
  }
}
