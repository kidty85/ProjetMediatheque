<%-- 
    Document   : membreMedias
    Created on : 12 déc. 2016, 00:18:23
    Author     : quangminhnguyen
--%>

<%@page import="entite.Emprunt"%>
<%@page import="java.util.List"%>
<%@page import="entite.Media"%>
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
                        <li class="active"><p><a href="./MembreMedias">Consulter les médias</a></p></li>
                        <li><p><a href="./MembreEmprunts">Consulter les emprunts</a></p></li>
                        <li><p><a href="./MembreDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">  
                    <h2>Liste des médias</h2>
                    <br>
                    <%
                        String message = (String) request.getSession().getAttribute("emprunt");
                        request.getSession().removeAttribute("emprunt");
                        if (message != null) {
                            if (message.equals("ok")) {
                                out.println("<div class='alert alert-success' role='alert'><b>Emprunt réussi avec succès.</b></div>");
                            } else if (message.equals("ko")) {
                                out.println("<div class='alert alert-danger' role='alert'><b>Vous n'avez pas le droit d'emprunter plus de 5 médias simultanément.</b></div>");
                            }
                        }
                    %>
                    <br>
                    <%
                        List<Media> mediaList = (List<Media>) request.getAttribute("listeMedia");
                        List<Media> mediaEmpruntList = (List<Media>) request.getAttribute("listeEmpruntMedia");

                        out.println("<table class='table table-striped'> "
                                + "<tr> "
                                + "<th><center>Média #</center></th> "
                                + "<th><center>Titre</center></th> "
                                + "<th><center>Catégorie</center></th> "
                                + "<th><center>Année</center></th> "
                                + "<th><center>Description</center></th> "
                                + "<th><center>Jours de prêt</center></th> "
                                + "<th><center>Emprunter</center></th> "
                                + "</tr>");
                        for (Media media : mediaList) {
                            String params = "Emprunter_" + media.getMediaId();
                            String empruntPossible = "<form id='emprunter' action='/MediathequeProjet-war/Membre' method='post'>"
                                    + "<button type='submit' name='actionButton' value='" + params + "'> Emprunter </button>"
                                    + "</form>";
                            for (Media mediaEmprunt : mediaEmpruntList) {
                                if (media.getMediaId() == mediaEmprunt.getMediaId()) {
                                    empruntPossible = "<a href=''>Emprunt en cours</a>";
                                }
                            }
                            out.println("<tr>");
                            out.println("<td><center>" + media.getMediaId() + "</center></td> "
                                    + "<td><center>" + media.getTitre() + "</center></td> "
                                    + "<td><center>" + media.getCategorie() + "</center></td> "
                                    + "<td><center>" + media.getAnnee() + "</center></td> "
                                    + "<td><center>" + media.getDescription() + "</center></td> "
                                    + "<td><center>" + media.getJoursPret() + "</center></td> "
                                    + "<td><center>" + empruntPossible + "</center></td> "
                                    + "</tr>");
                        }
                        out.println("</table>");
                        out.println("<div>" + "</div>");
                    %>
                </div>
                <br><br><br>
            </div>
            <div class=col-md-1></div>
        </div>
    </body>
</html>
