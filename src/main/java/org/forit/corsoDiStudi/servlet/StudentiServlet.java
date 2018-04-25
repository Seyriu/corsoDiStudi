/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dto.StudenteDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author UTENTE
 */
public class StudentiServlet extends CorsoDiStudiServlet {

  private final static String THEAD
          = "<thead>"
          + "    <tr>"
          + "        <th class='col-sm-1'>"
          + "            <a href='?action=new' class='btn btn-primary'>Nuovo</a>"
          + "        </th>"
          + "        <th class='col-sm-2'>Nome</th>"
          + "        <th class='col-sm-2'>Cognome</th>"
          + "        <th class='col-sm-2'>Data Di Nascita</th>"
          + "        <th class='col-sm-2'>Codice Fiscale</th>"
          + "        <th class='col-sm-3'>Email</th>"
          + "        <th class='col-sm-1'>Matricola</th>"
          + "    </tr>"
          + "</thead>";

  public static String THEAD_TASSA
          = "                             <thead>\n"
          + "                                <tr>\n"
          + "                                    <th class='col-sm-6'>ISEE</th>\n"
          + "                                    <th class='col-sm-6'>Costo</th>\n"
          + "                                </tr>\n"
          + "                            </thead>";
  
    private static String THEAD_VOTI
          = "                            <thead>\n"
          + "                                <tr>\n"
          + "                                    <th class='col-sm-6'>Materia</th>\n"
          + "                                    <th class='col-sm-3'>Voto</th>\n"
          + "                                    <th class='col-sm-3'>Data</th>\n"
          + "                                </tr>\n"
          + "                            </thead>";

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    long id = Long.parseLong(req.getParameter("id"));
    String nome = req.getParameter("nome");
    String cognome = req.getParameter("cognome");
    LocalDate dataNascita = LocalDate.parse(req.getParameter("dataNascita"));
    String codiceFiscale = req.getParameter("codiceFiscale");
    String mail = req.getParameter("mail");
    String matricola = req.getParameter("matricola");

    try {
      StudenteDTO studente = new StudenteDTO(id, nome, cognome, dataNascita, codiceFiscale, matricola, mail);
        CorsoDiStudiDAO cdsDAO = new CorsoDiStudiDAO();
      cdsDAO.updateStudente(studente);
      
//      resp.sendRedirect("clienti"); oppure this.doGet()...
      this.doGet(req, resp);
    } catch (CDSException ex) {
      System.out.println("Si e' verificato un errore " + ex.getLocalizedMessage());
      resp.sendRedirect("clienti?ID=" + id + "&action=edit");
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    String action = req.getParameter("action");
    if (action == null) {
      this.listaStudenti(resp);
    } else {
      String id = req.getParameter("ID");
      switch (action) {
        case "view":
          this.dettaglioStudente(resp, Long.parseLong(id), true);
          break;
        case "edit":
          this.dettaglioStudente(resp, Long.parseLong(id), false);
          break;
        case "new":
          break;
        default:
          this.listaStudenti(resp);
      }
    }
  }

  private void dettaglioStudente(HttpServletResponse resp, long id, boolean disabled) throws IOException {
    StudenteDTO studente = null;
    String messaggioErrore = null;

    try {
      CorsoDiStudiDAO studenteDAO = new CorsoDiStudiDAO();
      studente = studenteDAO.getStudente(id);
    } catch (CDSException ex) {
      messaggioErrore = "Impossibile leggere i dati dal database: " + ex.getLocalizedMessage();
    }

    try (PrintWriter out = resp.getWriter()) {
      this.apriHTML(out, messaggioErrore, "$$studenti$$");

      if (studente != null) {
        this.creaDettaglioStudente(out, studente, disabled);
      }

      this.chiudiHTML(out);
    }
  }

  private void creaDettaglioStudente(PrintWriter out, StudenteDTO studente, boolean disabled) {
    out.println("<form class='container-fluid' action='studenti' method='post'>");
    out.println("<div class='panel panel-default'>");
    out.println("<div class='panel-heading'>");
    out.println("<div class='panel-title'>Dettaglio Studente</div>");
    out.println("</div>");
    out.println("<div class='panel-body'>");
    out.println("<input type='hidden' name='id' value='" + studente.getId() + "' />");
    this.creaDatiAnagrafici(out, studente, disabled);
    this.creaTabellaTasse(out, studente);
    this.creaTabellaVoti(out, studente);

    out.println("</div>");
    out.println("<div class='panel-footer text-right'>");
    if (!disabled) {
      out.println("<input type='submit' class='btn btn-primary' value='Salva Modifiche'/>");
    }
    out.println("</div>");
    out.println("</div>");
    out.println("</form>");
  }

  private void creaDatiAnagrafici(PrintWriter out, StudenteDTO studente, boolean disabled) {
    out.println("<div class='row'>");
    out.println("<div class='col-sm-6'>");
    out.println("<label>Nome</label>");
    out.println("<input type='text' name='nome' class='form-control' value='" + studente.getNome() + "'" + (disabled ? " disabled='disabled'" : "") + ">");
    out.println("</div>");
    out.println("<div class='col-sm-6'>");
    out.println("<label>Cognome</label>");
    out.println("<input type='text' name='cognome' class='form-control' value='" + studente.getCognome() + "'" + (disabled ? " disabled='disabled'" : "") + ">");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class='row'>");
    out.println("<div class='col-sm-6'>");
    out.println("<label>Data Di Nascita</label>");
    out.println("<input type='date' name='dataNascita' class='form-control' value='" + studente.getDataNascita() + "'" + (disabled ? " disabled='disabled'" : "") + ">");
    out.println("</div>");
    out.println("<div class='col-sm-6'>");
    out.println("<label>Codice Fiscale</label>");
    out.println("<input type='text' name='codiceFiscale' class='form-control' value='" + studente.getCodiceFiscale() + "'" + (disabled ? " disabled='disabled'" : "") + ">");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class='row'>");
    out.println("<div class='col-sm-6'>");
    out.println("<label>Email</label>");
    out.println("<input type='email' name='mail' class='form-control' value='" + studente.getMail() + "'" + (disabled ? " disabled='disabled'" : "") + ">");
    out.println("</div>");
    out.println("<div class='col-sm-6'>");
    out.println("<label>Matricola</label>");
    out.println("<input type='text' name='matricola' class='form-control' value='" + studente.getMatricola() + "'" + (disabled ? " disabled='disabled'" : "") + ">");
    out.println("</div>");
    out.println("</div>");
  }

  private void creaTabellaTasse(PrintWriter out, StudenteDTO studente) {
    out.println("<div class='row'>");
    out.println("<div class='col-sm-12'>");
    out.println("<h3>Abbonamenti</h3>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class='table-responsive'>");
    out.println("<table class='table'>");
    out.println(THEAD_TASSA);
    out.println("<tbody'>");
    studente.getTasse().forEach(tasse -> {
      out.println("<tr>");
      out.println("<td>" + tasse.getIsee() + "</td>");
      out.println("<td>" + tasse.getCosto() + " &euro;</td>");
      out.println("</tr>");
    });
    out.println("</tbody'>");
    out.println("</table>");
    out.println("</div>");
  }
  
  private void creaTabellaVoti(PrintWriter out, StudenteDTO studente) {
    out.println("<div class='row'>");
    out.println("<div class='col-sm-12'>");
    out.println("<h3>Valutazioni</h3>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class='table-responsive'>");
    out.println("<table class='table'>");
    out.println(THEAD_VOTI);
    out.println("<tbody'>");
    studente.getVoti().forEach(voto -> {
      out.println("<tr>");
      out.println("<td>" + voto.getMateria()+ "</td>");
      out.println("<td>" + voto.getValutazione() + "/30</td>");
      out.println("<td>" + voto.getDataVoto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "</td>");
      out.println("</tr>");
    });
    out.println("</tbody'>");
    out.println("</table>");
    out.println("</div>");
  }


  private void listaStudenti(HttpServletResponse resp) throws IOException {
    List<StudenteDTO> studenti;
    String messaggioErrore = null;

    try {
      CorsoDiStudiDAO corsoDiStudiDAO = new CorsoDiStudiDAO();
      studenti = corsoDiStudiDAO.getListaStudenti();
    } catch (CDSException ex) {
      studenti = new ArrayList<>();
      messaggioErrore = "Impossibile leggere i dati dal database" + ex.getLocalizedMessage();
    }

    try (PrintWriter out = resp.getWriter()) {
      this.apriHTML(out, messaggioErrore, "$$studenti$$");
      this.createTabellaStudenti(out, studenti);
      this.chiudiHTML(out);
    }
  }

  private void createTabellaStudenti(PrintWriter out, List<StudenteDTO> studenti) {
    out.println("<div class='table-responsive'>");
    out.println("<table class='table'>");
    out.println(THEAD);
    out.println("<tbody>");
    studenti.forEach(studente -> {
      out.println("<tr>");
      out.println("  <td>");
      out.println("    <a href='?ID=" + studente.getId() + "&action=view' class='btn btn-default' title='Visualizza Dettaglio'>");
      out.println("      <span class='glyphicon glyphicon-eye-open'></span>");
      out.println("    </a>");
      out.println("    <a href='?ID=" + studente.getId() + "&action=edit' class='btn btn-default' title='Modifica Dati'>");
      out.println("      <span class='glyphicon glyphicon-pencil'></span>");
      out.println("    </a>");
      out.println("  </td>");
      out.println("  <td>" + studente.getNome() + "</td>");
      out.println("  <td>" + studente.getCognome() + "</td>");
      out.print("<td>" + studente.getDataNascita().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + "</td >");
      out.print("<td>" + studente.getCodiceFiscale() + "</td >");
      out.println("  <td>" + studente.getMail() + "</td>");
      out.println("  <td>" + studente.getMatricola()+ "</td>");
      out.println("</tr>");
    });
    out.println("</tbody>");
    out.println("</table>");
    out.println("</div>");
  }
}
