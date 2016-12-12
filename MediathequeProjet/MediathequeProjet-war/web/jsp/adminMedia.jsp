<%-- 
    Document   : adminMedia
    Created on : 11 déc. 2016, 15:46:37
    Author     : quangminhnguyen
--%>


<%@page import="entite.Media"%>
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
                        <li><p><a href="./AdminEmprunts">Lister les emprunts</a></p></li>
                        <li class="active"><p><a href="./AdminMedias">Lister les médias</a></p></li>
                        <li><p><a href="./AdminDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">
                    <h2>Liste des médias</h2>
                    <br><br>
                    <%
                        List<Media> mediaList = (List<Media>) request.getAttribute("listeMedia");
                        out.println("<table class='table table-striped'> "
                                + "<tr> "
                                + "<th><center>Média #</center></th> "
                                + "<th><center>Titre</center></th> "
                                + "<th><center>Catégorie</center></th> "
                                + "<th><center>Année</center></th> "
                                + "<th><center>Description</center></th> "
                                + "<th><center>Jours de prêt</center></th> "
                                + "<th><center>Stock</center></th> "
                                + "</tr>");
                        for (Media media : mediaList) {
                            out.println("<tr>");
                            out.println("<td><center>" + media.getMediaId() + "</center></td> "
                                    + "<td><center>" + media.getTitre() + "</center></td> "
                                    + "<td><center>" + media.getCategorie() + "</center></td> "
                                    + "<td><center>" + media.getAnnee() + "</center></td> "
                                    + "<td><center>" + media.getDescription() + "</center></td> "
                                    + "<td><center>" + media.getJoursPret() + "</center></td> "
                                    + "<td><center>" + media.getStock() + "</center></td> "
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
