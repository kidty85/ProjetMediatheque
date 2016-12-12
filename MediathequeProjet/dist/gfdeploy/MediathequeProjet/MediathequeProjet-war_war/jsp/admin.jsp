<%-- 
    Document   : admin
    Created on : 4 déc. 2016, 17:20:06
    Author     : quangminhnguyen
--%>

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
                        <li class="active"><p><a href="./Admin">Administrateur</a></p></li>
                        <li><p><a href="./AdminAjout">Ajouter un média</a></p></li>
                        <li><p><a href="./AdminMembres">Lister les membres</a></p></li>
                        <li><p><a href="./AdminEmprunts">Lister les emprunts</a></p></li>
                        <li><p><a href="./AdminMedias">Lister les médias</a></p></li>
                        <li><p><a href="./AdminDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">  
                    <h2>Bienvenue
                        <%
                            out.println((String) request.getAttribute("admin") + " !");
                        %>
                    </h2>
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                </div>
            </div>
            <div class=col-md-1></div>
        </div>
    </body>
</html>
