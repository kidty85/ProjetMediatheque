<%-- 
    Document   : adminAjout
    Created on : 11 déc. 2016, 15:44:36
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
                        <li><p><a href="./Admin">Administrateur</a></p></li>
                        <li class="active"><p><a href="./AdminAjout">Ajouter un média</a></p></li>
                        <li><p><a href="./AdminMembres">Lister les membres</a></p></li>
                        <li><p><a href="./AdminEmprunts">Lister les emprunts</a></p></li>
                        <li><p><a href="./AdminMedias">Lister les médias</a></p></li>
                        <li><p><a href="./AdminDeconnexion">Déconnexion</a></p></li>
                    </ul>
                </div>   
                <div id="right">
                    <h2>Ajouter un média</h2>
                    <br>
                    <%
                        String message = (String) request.getSession().getAttribute("ajout");
                        if (message != null) {
                            if (message.equals("ok")) {
                                out.println("<div class='alert alert-success' role='alert'><b>Média ajouté avec succès.</b></div>");
                            }
                            request.getSession().removeAttribute("ajout");
                        }
                    %>
                    <br>
                    <form id="ajout" action="${pageContext.request.contextPath}/Admin" method="post" >
                        <label>
                            <output>Titre : </output>
                            <input type="text" name="titre" placeholder="Titre" size="30" required />
                        </label><br/>
                        <label>
                            <output>Catégorie :</output>
                            <select name="categorie" size="1" required >
                                <option disabled selected value>Choisissez une catégorie</option>
                                <option>ARCHIVE</option>
                                <option>AUDIO</option>
                                <option>JOURNAL</option>
                                <option>LIVRE</option>
                                <option>VIDEO</option>
                            </select>
                        </label><br/>
                        <label>
                            <output>Année : </output>
                            <input type="text" name="annee" placeholder="Année" size="30" 
                                   pattern="\d{4}" required title="Année avec 4 chiffres" />
                        </label><br/>
                        <label>
                            <output>Description : </output>
                            <textarea type="text" name="description" placeholder="Description..." size="30" 
                                      rows="5" cols="60" maxlength="255" required ></textarea>
                        </label><br/>
                        <label>
                            <output>Jours de prêt : </output>
                            <input type="number" name="jours" placeholder="Nombre de jours" size="30" 
                                   min="1" max="30" required />
                        </label><br/>
                        <label>
                            <output>Quantité en stock : </output>
                            <input type="number" name="stock" placeholder="Stock" size="30" 
                                   min="1" max="100" required />
                        </label><br/>
                        <br>
                            <button type="submit" name="actionButton" value="Ajouter">Ajouter</button>
                    </form>
                </div>
                <br><br><br><br><br><br>
            </div>
            <div class=col-md-1></div>
        </div>
    </body>
</html>