/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dao;

import java.math.BigDecimal;
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
import org.forit.corsoDiStudi.dto.StudenteDTO;
import org.forit.corsoDiStudi.dto.TasseDTO;
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
  private static final String GET_PROFESSORI = "SELECT * FROM professore;";

  private static final String LISTA_STUDENTI
          = "SELECT "
          + "* "
          + "FROM "
          + "studente "
          + "ORDER BY COGNOME,NOME";

  public static final String INSERISCI_STUDENTE
          = "INSERT INTO STUDENTE (NOME,COGNOME,DATA_DI_NASCITA,CODICE_FISCALE,MAIL,MATRICOLA,ID_CLASSE)"
          + " VALUES(?,?,?,?,?,?,?)";

  private static final String MATERIA_X_PROFESSORE = "SELECT P.NOME,P.COGNOME,M.NOME MATERIA "
          + "FROM materia m,materia_x_prof mxp,professore P "
          + " where m.id=mxp.ID_MATERIA and mxp.ID_PROF=P.ID ";

  private static final String LISTA_TASSE
          = "SELECT "
          + "    t.* "
          + "FROM "
          + "    tassa t ";

  private static final String STUDENTE
          = "SELECT * "
          + "FROM studente s "
          + "WHERE s.ID=?";

  private static final String TASSE_X_STUDENTE
          = "SELECT t.* "
          + "FROM studente s, tassa t "
          + "WHERE s.ID=? and t.ID=s.ID_TASSA";

  private static final String VOTI_X_STUDENTE
          = "SELECT v.ID, v.VALUTAZIONE, V.DATA, m.NOME NOME_MATERIA, sm.SEMESTRE NOME_SEMESTRE, sm.ANNO ANNO_SEMESTRE \n"
          + "FROM studente s, voto v, materia m, semestre sm\n"
          + "WHERE s.ID=? and v.ID_STUDENTE=s.ID and m.ID=v.ID_MATERIA and sm.ID=v.ID_SEMESTRE";

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
            ResultSet rs = st.executeQuery(GET_PROFESSORI)) {

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

  public List<StudenteDTO> getListaStudenti() throws CDSException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(LISTA_STUDENTI)) {

      List<StudenteDTO> studenti = new ArrayList<>();
      while (rs.next()) {
        studenti.add(new StudenteDTO(
                rs.getLong("ID"),
                rs.getString("NOME"),
                rs.getString("COGNOME"),
                rs.getDate("DATA_DI_NASCITA").toLocalDate(),
                rs.getString("CODICE_FISCALE"),
                rs.getString("MATRICOLA"),
                rs.getString("MAIL"))
        );
      }
      return studenti;
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore: " + ex.getLocalizedMessage());
      throw new CDSException(ex);
    }
  }

  public void insertStudente(String Nome, String cognome, LocalDate dataNascita, String codiceFiscale, String mail, String matricola, long idClasse) throws CDSException {

    try (Connection conn = DriverManager.getConnection(DB_URL)) {
      conn.setAutoCommit(false);

      try (PreparedStatement ps1 = conn.prepareStatement(INSERISCI_STUDENTE, Statement.RETURN_GENERATED_KEYS);) {
        ps1.setString(1, Nome);
        ps1.setString(2, cognome);
        ps1.setDate(3, Date.valueOf(dataNascita));
        ps1.setString(4, codiceFiscale);
        ps1.setString(5, mail);
        ps1.setString(6, matricola);
        ps1.setLong(7, idClasse);
        ps1.executeUpdate();

        conn.commit();
      } catch (SQLException ex) {
        conn.rollback();
        throw ex;
      }

    } catch (SQLException ex) {

      System.out.println("Si è verificato un errore " + ex);
      throw new CDSException(ex);
    }
  }

  public List<TasseDTO> getListaTasse() throws CDSException {
    try (Connection conn = DriverManager.getConnection(DB_URL);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(LISTA_TASSE)) {

      List<TasseDTO> listaTasse = new ArrayList<>();

      while (rs.next()) {
        long id = rs.getLong("ID");
        String isee = rs.getString("ISEE");
        BigDecimal costo = rs.getBigDecimal("COSTO");

        TasseDTO tassa = new TasseDTO(id, isee, costo);
        listaTasse.add(tassa);

      }
      return listaTasse;
    } catch (SQLException ex) {
      System.out.println("Si e' verificato un errore " + ex.getMessage());
      throw new CDSException(ex);
    }
  }

  public StudenteDTO getStudente(long id) throws CDSException {
    try (
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement ps1 = conn.prepareStatement(STUDENTE);
            PreparedStatement ps2 = conn.prepareStatement(TASSE_X_STUDENTE);
            PreparedStatement ps3 = conn.prepareStatement(VOTI_X_STUDENTE)) {

      ps1.setLong(1, id);
      ResultSet rs = ps1.executeQuery();
      rs.next();

      String nome = rs.getString("NOME");
      String cognome = rs.getString("COGNOME");
      LocalDate dataNascita = rs.getDate("DATA_DI_NASCITA").toLocalDate();
      String mail = rs.getString("MAIL");
      String codiceFiscale = rs.getString("CODICE_FISCALE");
      String matricola = rs.getString("MATRICOLA");

      StudenteDTO studente = new StudenteDTO(id, nome, cognome, dataNascita, codiceFiscale, matricola, mail);

      ps2.setLong(1, id);
      rs = ps2.executeQuery();
      while (rs.next()) {
        Long idTassa = rs.getLong("ID");
        String iseeTassa = rs.getString("ISEE");
        BigDecimal costoTassa = rs.getBigDecimal("COSTO");

        TasseDTO tassa = new TasseDTO(idTassa, iseeTassa, costoTassa);
        studente.getTasse().add(tassa);
      }

      ps3.setLong(1, id);
      rs = ps3.executeQuery();
      while (rs.next()) {
        long idVoto = rs.getLong("ID");
        int valutazione = rs.getInt("VALUTAZIONE");
        LocalDate dataVoto = rs.getDate("DATA").toLocalDate();
        String materia = rs.getString("NOME_MATERIA");
        int semestre = rs.getInt("NOME_SEMESTRE");
        int annoSemestre = rs.getInt("ANNO_SEMESTRE");

        VotoDTO voto = new VotoDTO(idVoto, valutazione, semestre, annoSemestre, materia, dataVoto);
        studente.getVoti().add(voto);
      }

      return studente;
    } catch (SQLException ex) {
      System.out.println("Si è verificato un errore " + ex.getMessage());
      throw new CDSException(ex);
    }
  }
}
