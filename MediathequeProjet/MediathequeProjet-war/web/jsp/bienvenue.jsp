<%-- 
    Document   : bienvenue
    Created on : 4 déc. 2016, 16:54:41
    Author     : quangminhnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil Mediatheque</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div style="height: 700px">
            <div class=col-md-1></div>
            <div class=col-md-10 style=background:ghostwhite;height:70%>
                <div id="top">
                    <h1 style=position:absolute;right:20%;top:10px;><b><em>Médiathèque UP13</em></b></h1><br>
                </div>
                <br><br>
                <div class=col-md-6 style="display: inline-block; border-right: dashed; height: 100%">
                    <center>
                        <h3>Connexion</h3>
                        <form id="connexion" action="${pageContext.request.contextPath}/Accueil" method="post">
                            <label>
                                <output>Email : </output>
                                <input type="email" name="mailConnexion" placeholder="Votre email" required/>
                            </label><br>
                            <label>
                                <output>Mot de passe : </output>
                                <input type="password" name="mdpConnexion" placeholder="Votre mot de passe" required/>
                            </label><br>
                            <button type="submit" name="actionButton" value="connexion"> Connexion </button>
                        </form>
                    </center>
                    <br><br><br><br><br><br><br><br><br><br>
                </div>
                <div class=col-md-6 style="display: inline-block; height: 100%">
                    <center>
                        <h3>Inscription</h3>
                        <form id="connexion" action="${pageContext.request.contextPath}/Accueil" method="post">
                            <label>
                                <output>Nom : </output>
                                <input type="text" name="nomInscription" placeholder="Votre nom" required/>
                            </label><br>
                            <label>
                                <output>Prénom : </output>
                                <input type="text" name="prenomInscription" placeholder="Votre prénom" required/>
                            </label><br>
                            <label>
                                <output>Email : </output>
                                <input type="email" name="mailInscription" placeholder="Votre email" required/>
                            </label><br>
                            <label>
                                <output>Mot de passe : </output>
                                <input type="password" id="mdpInscription" name="mdpInscription" placeholder="Votre mot de passe"
                                       pattern=".{8,}" required title="8 caractères minimum"/>
                            </label><br>
                            <label>
                                <output>Confirmez votre mot de passe : </output>
                                <input type="password" id="mdpConfirmInscription" name="mdpConfirmInscription" 
                                       placeholder="Confirmez votre mot de passe" required/>
                            </label><br>
                            <button type="submit" name="actionButton" value="inscription"> Inscription </button>
                        </form>
                    </center>
                    <br><br><br><br>
                </div>
            </div>
            <br><br><br><br><br>
            <div class=col-md-1></div>
        </div>
    </body>
</html>

<script>
    var password = document.getElementById("mdpInscription");
    var confirm_password = document.getElementById("mdpConfirmInscription");

    function validatePassword() {
        if (password.value !== confirm_password.value) {
            confirm_password.setCustomValidity("Les mots de passe ne sont pas identiques !");
        } else {
            confirm_password.setCustomValidity("");
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>