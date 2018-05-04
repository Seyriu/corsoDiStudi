/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dao;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.forit.corsoDiStudi.dto.StudenteDTO;
import org.forit.corsoDiStudi.dto.TassaDTO;
import org.forit.corsoDiStudi.entity.StudenteEntity;
import org.forit.corsoDiStudi.entity.TassaEntity;

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


    StudenteDTO sdto = new StudenteDTO(id, nome, cognome, dataNascita, codiceFiscale, matricola, mail);

    TassaEntity tassa = studente.getTassa();
    TassaDTO tdto = new TassaDTO(tassa.getId(), tassa.getIsee(), tassa.getCosto());
    sdto.setTassa(tdto);
    
    em.close();
    emf.close();
//
//      ps3.setLong(1, id);
//      rs = ps3.executeQuery();
//      while (rs.next()) {
//        long idVoto = rs.getLong("ID");
//        int valutazione = rs.getInt("VALUTAZIONE");
//        LocalDate dataVoto = rs.getDate("DATA").toLocalDate();
//        Long idMateria = rs.getLong("ID_MATERIA");
//
//        VotoDTO voto = new VotoDTO(idVoto, id, idMateria, valutazione, dataVoto);
//        voto.setProfessori(getProfessoriFromIdVoto(idVoto));
//        studente.getVoti().add(voto);
//      }
    return sdto;
  }
}
