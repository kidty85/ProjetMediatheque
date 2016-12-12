<%-- 
    Document   : membreEmprunt
    Created on : 12 déc. 2016, 00:19:02
    Author     : quangminhnguyen
--%>

<%@page import="entite.Emprunt"%>
<%@page import="java.util.List"%>
<%@page import="entite.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Membre</title>
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
                <%
                    Membre membre = (Membre) request.getAttribute("membre");
                    String membreString = membre.getNom() + " " + membre.getPrenom();
                %>
                <div id="left">
                    <ul>
                        <li><p><a href="./Membre"><%out.println(membreString);%></a></p></li>
                        <li><p><a href="./MembreMedias">Consulter les médias</a></p></li>
                        <li class="active"><p><a href="./MembreEmprunts">Consulter les emprunts</a></p></li>
                        <li><p><a href="./MembreDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">  
                    <h2>Liste des médias empruntés</h2>
                    <br>
                    <%
                        String message = (String) request.getSession().getAttribute("rendre");
                        request.getSession().removeAttribute("emprunt");
                        if (message != null) {
                            if (message.equals("ok")) {
                                out.println("<div class='alert alert-success' role='alert'><b>Média rendu avec succès.</b></div>");
                            }
                        }
                    %>
                    <br>
                    <%
                        List<Emprunt> empruntList = (List<Emprunt>) request.getAttribute("listeEmprunt");

                        out.println("<table class='table table-striped'> "
                                + "<tr> "
                                + "<th><center>Titre</center></th> "
                                + "<th><center>Catégorie</center></th> "
                                + "<th><center>Année</center></th> "
                                + "<th><center>Date emprunt</center></th> "
                                + "<th><center>Jours de prêt</center></th> "
                                + "<th><center>Rendre</center></th> "
                                + "</tr>");
                        for (Emprunt emprunt : empruntList) {
                            String params = "Rendre_" + emprunt.getEmpruntId();
                            String rendre = "<form id='rendre' action='/MediathequeProjet-war/Membre' method='post'>"
                                    + "<button type='submit' name='actionButton' value='" + params + "'> Rendre </button>"
                                    + "</form>";
                            int date = emprunt.getDateEmprunt().getDate();
                            int month = 1 + emprunt.getDateEmprunt().getMonth();
                            int year = 1900 + emprunt.getDateEmprunt().getYear();
                            out.println("<tr>");
                            out.println("<td><center>" + emprunt.getMediaId().getTitre() + "</center></td> "
                                    + "<td><center>" + emprunt.getMediaId().getCategorie() + "</center></td> "
                                    + "<td><center>" + emprunt.getMediaId().getAnnee() + "</center></td> "
                                    + "<td><center>" + date + "/" + month + "/" + year + "</center></td> "
                                    + "<td><center>" + emprunt.getMediaId().getJoursPret() + "</center></td> "
                                    + "<td><center>" + rendre + "</center></td> "
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
