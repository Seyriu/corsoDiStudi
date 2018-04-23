/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.forit.corsoDiStudi.dto.ProfessoreDTO;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author Utente
 */
public class CorsoDiStudiDAO {

  private static final String DB_URL = "jdbc:mysql://localhost:3306/corsodistudi?user=forit&password=12345&useSSL=false";
  private static final String INSERT_VOTO = "insert into voto values (null,?, ?, ?, ?, ?)";
  private static final String INSERT_VXP = "insert into voto_x_prof values (?, ?);";
  private static final String STUDENTS_N_BY_CLASS
          = "SELECT c.NOME, count(*) N_ALUNNI "
          + "FROM studente s, classe c "
          + "where s.ID_CLASSE=c.ID "
          + "group by c.NOME "
          + "order by c.NOME";
  private static final String GETPROFESSORI = "SELECT * FROM corsodistudi.professore;";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
  
  public void insertVoto(int valutazione, LocalDate dataVoto, int idSemestre, int idMateria, int idStudente, int idProf) throws CDSException {
    try (Connection conn = DriverManager.getConnection(DB_URL)) {
      conn.setAutoCommit(false);
      try (
              PreparedStatement ps1 = conn.prepareStatement(INSERT_VOTO, Statement.RETURN_GENERATED_KEYS);
              PreparedStatement ps2 = conn.prepareStatement(INSERT_VXP)) {
        ps1.setInt(1, valutazione);
        ps1.setDate(2, Date.valueOf(dataVoto));
        ps1.setLong(3, idSemestre);
        ps1.setLong(4, idMateria);
        ps1.setLong(5, idStudente);
        ps1.executeUpdate();
        ResultSet generatedKey = ps1.getGeneratedKeys();
        generatedKey.next();
        Long id = generatedKey.getLong(1);

        ps2.setLong(1, idProf);
        ps2.setLong(2, id);
        ps2.executeUpdate();

        conn.commit();
      } catch (SQLException ex) {
        conn.rollback();
        throw ex;
      }
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      throw new CDSException(ex);
    }
  }

  public void insertVoto(VotoDTO voto) throws CDSException {
    try (Connection conn = DriverManager.getConnection(DB_URL)) {
      conn.setAutoCommit(false);
      try (
              PreparedStatement ps1 = conn.prepareStatement(INSERT_VOTO, Statement.RETURN_GENERATED_KEYS);
              PreparedStatement ps2 = conn.prepareStatement(INSERT_VXP)) {
        ps1.setInt(1, voto.getValutazione());
        ps1.setDate(2, Date.valueOf(voto.getDataVoto()));
        ps1.setLong(3, voto.getIdSemestre());
        ps1.setLong(4, voto.getIdMateria());
        ps1.setLong(5, voto.getIdStudente());
        ps1.executeUpdate();
        ResultSet generatedKey = ps1.getGeneratedKeys();
        generatedKey.next();
        Long id = generatedKey.getLong(1);

        ps2.setLong(1, voto.getIdProf());
        ps2.setLong(2, id);
        ps2.executeUpdate();

        conn.commit();
      } catch (SQLException ex) {
        conn.rollback();
        throw ex;
      }
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      throw new CDSException(ex);
    }
  }

  public Map<String, Integer> getStudentsInEachClass() throws CDSException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(STUDENTS_N_BY_CLASS)) {

      Map<String, Integer> studentsInEachClass = new TreeMap<>();
      while (rs.next()) {
        studentsInEachClass.put(rs.getString("NOME"), rs.getInt("N_ALUNNI"));
      }
      return studentsInEachClass;
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      throw new CDSException(ex);
    }
  }

  public List<ProfessoreDTO> getListaProfessori() throws CDSException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(GETPROFESSORI)) {

      List<ProfessoreDTO> professori = new ArrayList<>();
      while (rs.next()) {
        professori.add(new ProfessoreDTO(
                rs.getString("NOME"),
                rs.getString("COGNOME"),
                rs.getString("MAIL"),
                rs.getLong("ID"))
        );
      }
      return professori;
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      throw new CDSException(ex);
    }
  }
}
