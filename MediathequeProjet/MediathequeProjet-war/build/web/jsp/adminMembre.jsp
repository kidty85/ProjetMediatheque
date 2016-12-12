<%-- 
    Document   : adminMembre
    Created on : 11 déc. 2016, 15:47:29
    Author     : quangminhnguyen
--%>


<%@page import="java.util.List"%>
<%@page import="entite.Membre"%>
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
                        <li class="active"><p><a href="./AdminMembres">Lister les membres</a></p></li>
                        <li><p><a href="./AdminEmprunts">Lister les emprunts</a></p></li>
                        <li><p><a href="./AdminMedias">Lister les médias</a></p></li>
                        <li><p><a href="./AdminDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">
                    <h2>Liste des membres</h2>
                    <br><br>
                    <%
                        List<Membre> membreList = (List<Membre>) request.getAttribute("listeMembres");
                        out.println("<table class='table table-striped'> "
                                + "<tr> "
                                + "<th><center>Membre #</center></th> "
                                + "<th><center>Nom</center></th> "
                                + "<th><center>Prénom</center></th> "
                                + "<th><center>Mail</center></th> "
                                + "</tr>");
                        for (Membre membre : membreList) {
                            out.println("<tr>");
                            out.println("<td><center>" + membre.getMembreId() + "</center></td> "
                                    + "<td><center>" + membre.getNom() + "</center></td> "
                                    + "<td><center>" + membre.getPrenom() + "</center></td> "
                                    + "<td><center>" + membre.getMail() + "</center></td> "
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
