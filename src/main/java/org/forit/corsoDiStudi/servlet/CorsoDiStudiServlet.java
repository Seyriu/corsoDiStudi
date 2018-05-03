/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.servlet;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author UTENTE
 */
public class CorsoDiStudiServlet extends HttpServlet {

  protected final static String HEADPROFESSORI
          = "<head>\n"
          + "        <title>Corso Di Studi</title>\n"
          + "        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n"
          + "        <script type='text/javascript' src='js/jquery-3.3.1.js'></script>\n"
          + "        <script type='text/javascript' src='js/bootstrap.js'></script>\n"
          + "        <link rel='stylesheet' href='css/bootstrap.css' type='text/css'/>\n"
          + "        <link rel='icon' href='./img/cds_s.png'>\n"
          + "\n"
          + "        <style type='text/css'>\n"
          + "            .navbar-default {\n"
          + "                background-color: #eddead;\n"
          + "                border-color: #E7E7E7;\n"
          + "            }\n"
          + "        </style>\n"
          + "    </head>";

  protected final static String NAVBAR
          = "<nav class='navbar navbar-default'>\n"
          + "            <div class='container-fluid'>\n"
          + "                <div class='navbar-header'>\n"
          + "                    <button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#navigazione'>\n"
          + "                        <span class='icon-bar'></span>\n"
          + "                        <span class='icon-bar'></span>\n"
          + "                        <span class='icon-bar'></span>\n"
          + "                    </button>\n"
          + "                    <a class='navbar-brand' href='index.html'>\n"
          + "                        <img alt='CorsoDiStudi' src='./img/cds_s.png' width='20'>\n"
          + "                    </a>\n"
          + "                </div>\n"
          + "\n"
          + "                <div class='collapse navbar-collapse' id='navigazione'>\n"
          + "                    <ul class='nav navbar-nav'>\n"
          + "                        <li><a class='$$professori$$' href='professori'>Professori</a></li>\n"
          + "                        <li><a class='$$studenti$$' href='faces/studenti.xhtml'>Studenti</a></li>\n"
          + "                        <li><a class='$$orari$$' href='#'>Orari</a></li>\n"
          + "                        <li><a class='$$calendario$$' href='#'>Calendario</a></li>\n"
          + "                        <li class='$$dropdownmaterie$$' class='dropdown'>\n"
          + "                            <a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Materie <span class='caret'></span></a>\n"
          + "                            <ul class='dropdown-menu'>\n"
          + "                                <li><a href='#'>Calcolo</a></li>\n"
          + "                                <li><a href='#'>Architettura</a></li>\n"
          + "                                <li><a href='#'>Algoritmi</a></li>\n"
          + "                            </ul>\n"
          + "                        </li>\n"
          + "                        <li><a class='$$tasse$$' href='tasse'>Tasse</a></li> \n"
          + "                        <li><a class='$$contatti$$' href='#'>Contatti</a></li>                         \n"
          + "                    </ul>                                        \n"
          + "                </div>\n"
          + "            </div>\n"
          + "        </nav>";

  protected void apriHTML(PrintWriter out, String messaggioErrore, String active) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println(HEADPROFESSORI);
    out.println("<body>");
    out.println(NAVBAR.replace(active, "active"));

    if (messaggioErrore != null) {
      out.println("<h2>" + messaggioErrore + "</h2>");
    }
  }

  protected void chiudiHTML(PrintWriter out) {
    out.println("</body>");
    out.println("</html>");
  }
}
