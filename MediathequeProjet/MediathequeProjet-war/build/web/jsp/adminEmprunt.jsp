<%-- 
    Document   : adminEmprunt
    Created on : 11 déc. 2016, 15:45:31
    Author     : quangminhnguyen
--%>


<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="entite.MediaFacadeLocal"%>
<%@page import="entite.MembreFacadeLocal"%>
<%@page import="entite.MembreFacade"%>
<%@page import="entite.Emprunt"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Administrateur</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div>
            <div class=col-md-1></div>
            <div class=col-md-10 style=background:ghostwhite;height:70%>
                <div id="top">
                    <h1 style=position:absolute;right:20%;top:10px;><b><em>Médiathèque UP13</em></b></h1><br>
                </div>
                <br>
                <div id="left">
                    <ul>
                        <li><p><a href="./Admin">Administrateur</a></p></li>
                        <li><p><a href="./AdminAjout">Ajouter un média</a></p></li>
                        <li><p><a href="./AdminMembres">Lister les membres</a></p></li>
                        <li class="active"><p><a href="./AdminEmprunts">Lister les emprunts</a></p></li>
                        <li><p><a href="./AdminMedias">Lister les médias</a></p></li>
                        <li><p><a href="./AdminDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">
                    <h2>Liste des emprunts</h2>
                    <br><br>
                    <%
                        List<Emprunt> empruntList = (List<Emprunt>) request.getAttribute("listeEmprunts");
                        out.println("<table class='table table-striped'> "
                                + "<tr> "
                                + "<th><center>Emprunt #</center></th> "
                                + "<th><center>Membre</center></th> "
                                + "<th><center>Média</center></th> "
                                + "<th><center>Date</center></th> "
                                + "</tr>");

                        for (Emprunt emprunt : empruntList) {
                            int date = emprunt.getDateEmprunt().getDate();
                            int month = 1 + emprunt.getDateEmprunt().getMonth();
                            int year = 1900 + emprunt.getDateEmprunt().getYear();
                            out.println("<tr>");
                            out.println("<td><center>" + emprunt.getEmpruntId() + "</center></td> "
                                    + "<td><center>" + emprunt.getMembreId().getNom() + " " + emprunt.getMembreId().getPrenom() + "</center></td> "
                                    + "<td><center>" + emprunt.getMediaId().getTitre() + " (" + emprunt.getMediaId().getCategorie() + ")</center></td> "
                                    + "<td><center>" + date + "/" + month + "/" + year + "</center></td> "
                                    + "</tr>");
                        }
                        out.println("</table>");
                        out.println("<div>" + "</div>");
                    %>
                </div>
                <br><br><br><br><br>
            </div>
            <div class=col-md-1></div>
        </div>
    </body>
</html>
