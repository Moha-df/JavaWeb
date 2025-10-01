<%-- 
    Document   : Vue
    Created on : 26 sept. 2025, 14:44:16
    Author     : e2500138
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>TP3</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #121212;
            color: #e0e0e0;
            padding: 40px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100vh;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            max-width: 600px;
            margin-bottom: 30px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.7);
            border-radius: 8px;
            overflow: hidden;
            background-color: #1e1e1e;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #333;
        }
        th {
            background-color: #333;
            color: #fff;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #2c2c2c;
        }
        tr:hover {
            background-color: #444;
        }
        form {
            background-color: #1e1e1e;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.7);
            width: 300px;
            margin-top: 30px;
        }
        div {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
            font-weight: bold;
            color: #ccc;
        }
        input[type="number"],
        select,
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 20px;
            border: 1px solid #555;
            border-radius: 5px;
            box-sizing: border-box;
            background-color: #333;
            color: #eee;
        }
        input[type="submit"] {
            background-color: #4B0082;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #9370DB;
        }
        .resultat {
            margin-top: 50px;
            font-size: 24px;
        }
    </style>
</head>
<body>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%-- Récupérer l'attribut "brrbrr" depuis la session --%>
<%    
    ArrayList<String[]> tabStudents = (ArrayList<String[]>) session.getAttribute("brrbrr");
    
    if (tabStudents == null || tabStudents.isEmpty()) {
%>
        <p>Aucun étudiant trouvé.</p>
<% } else { %>
        <table border='1'>
            <tr>
                <th>Prénom</th>
                <th>Nom</th>
                <th>Notes</th>
            </tr>
            <%-- Boucle pour afficher les étudiants --%>
            <% for (String[] student : tabStudents) { %>
                <tr>
                    <td><%= student[0] %></td>
                    <td><%= student[1] %></td>
                    <td><%= student[2] %></td>
                </tr>
            <% } %>
        </table>
<% } %>

<%-- Formulaire d'ajout d'un étudiant --%>
<form action="./newStudent" method="post">
    First name : <input type="text" name="firstname"> <br>
    Last name : <input type="text" name="lastname"> <br>
    Grades : <input type="number" name="grades"> <br>
    <input type="submit" value="Send">
</form>

<%-- Formulaire pour supprimer tous les étudiants --%>
<form action="./deleteAllStudent" method="post">
    <input type="submit" value="Delete">
</form>

</body>
    
</html>
