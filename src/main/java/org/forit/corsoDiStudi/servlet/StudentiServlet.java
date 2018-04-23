/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
            + "    </tr>"
            + "</thead>";

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        this.listaStudenti(resp);
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
            out.print("<td>" + studente.getDataNascita().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"))+ "</td >");
                out.print("<td>" + studente.getCodiceFiscale() + "</td >");
            out.println("  <td>" + studente.getMail() + "</td>");
            out.println("</tr>");
        });
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
