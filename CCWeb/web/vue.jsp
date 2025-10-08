<%-- 
    Document   : vue
    Created on : 8 oct. 2025, 10:46:47
    Author     : e2500138
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="pack.Dessin"%>
        <%
            Dessin dessin = (Dessin) request.getAttribute("dessin");
            out.println(dessin.genererLeDessin());
        %>
        
        <h2>Remplir la zone de dessin</h2>
        
        <form action="./Servelet" method="post">
            <label for"char"> Charactere :</label>
            <input type ="text" id="charr" name="charr" required><br><br>
            <button type="submit" name="action" value="remplir"> Remplir le dessin</button>
        </form>
        
        <h2>Dessiner un rectangle</h2>
        <form action="./Servelet" method="post">
            <label for"num"> Respectivmenet x1 x2 et y1 y2 :</label>
            <input type ="number" id="num" name="x1" required>
            <input type ="number" id="num" name="x2" required><br><br>
            <input type ="number" id="num" name="y1" required>
            <input type ="number" id="num" name="y2" required><br><br>
            <input type ="text" id="charr" name="charr" required><br><br>
            <button type="submit" name="action" value="rectangle"> Dessiner un rectangle</button>
        </form>
    </body>
</html>
