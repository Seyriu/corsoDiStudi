/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.forit.corsoDiStudi.dao.CorsoDiStudiDAO;
import org.forit.corsoDiStudi.dto.ProfessoreDTO;
import org.forit.corsoDiStudi.dto.TassaDTO;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author UTENTE
 */
public class TasseServlet extends CorsoDiStudiServlet {

    private final static String THEAD
            = "<thead>"
            + "    <tr>"
            + "        <th class='col-sm-1'>"
            + "            <a href='?action=new' class='btn btn-primary'>Nuovo</a>"
            + "        </th>"
            + "        <th class='col-sm-2'>ISEE</th>"
            + "        <th class='col-sm-2'>Tasse</th>"
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

        this.listaProfessori(resp);
    }

    private void listaProfessori(HttpServletResponse resp) throws IOException {
        List<TassaDTO> tasse;
        String messaggioErrore = null;

        try {
            CorsoDiStudiDAO corsoDiStudiDAO = new CorsoDiStudiDAO();
            tasse = corsoDiStudiDAO.getListaTasse();
        } catch (CDSException ex) {
            tasse = new ArrayList<>();
            messaggioErrore = "Impossibile leggere i dati dal database" + ex.getLocalizedMessage();
        }

        try (PrintWriter out = resp.getWriter()) {
            this.apriHTML(out, messaggioErrore, "$$tasse$$");
            this.createTabellaTasse(out, tasse);
            this.chiudiHTML(out);
        }
    }

    private void createTabellaTasse(PrintWriter out, List<TassaDTO> tasse) {
        out.println("<div class='table-responsive'>");
        out.println("<table class='table'>");
        out.println(THEAD);
        out.println("<tbody>");
        tasse.forEach(tassa -> {
            out.println("<tr>");
            out.println("  <td>");
            out.println("    <a href='?ID=" + tassa.getId() + "&action=view' class='btn btn-default' title='Visualizza Dettaglio'>");
            out.println("      <span class='glyphicon glyphicon-eye-open'></span>");
            out.println("    </a>");
            out.println("    <a href='?ID=" + tassa.getId() + "&action=edit' class='btn btn-default' title='Modifica Dati'>");
            out.println("      <span class='glyphicon glyphicon-pencil'></span>");
            out.println("    </a>");
            out.println("  </td>");
            out.println("  <td>" + tassa.getIsee() + "</td>");
            out.println("  <td>" + tassa.getCosto() + " &euro;</td>");
            out.println("</tr>");
        });
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}
