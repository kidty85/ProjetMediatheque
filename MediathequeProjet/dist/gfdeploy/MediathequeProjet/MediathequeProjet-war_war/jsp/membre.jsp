<%-- 
    Document   : membre
    Created on : 4 déc. 2016, 17:31:42
    Author     : quangminhnguyen
--%>

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
                        <li class="active"><p><a href="./Membre"><%out.println(membreString);%></a></p></li>
                        <li><p><a href="./MembreMedias">Consulter les médias</a></p></li>
                        <li><p><a href="./MembreEmprunts">Consulter les emprunts</a></p></li>
                        <li><p><a href="./MembreDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">  
                    <h2>Bienvenue
                        <%
                            out.println(membreString + " !");
                        %>
                    </h2>
                </div>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            </div>
            <div class=col-md-1></div>
        </div>
    </body>
</html>

