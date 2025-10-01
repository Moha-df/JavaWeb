<%-- 
    Document   : Vue
    Created on : 26 sept. 2025, 14:20:09
    Author     : MohLeBG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            html, body {
                height: 100%;
                margin: 0;
            }

            body {
                display: flex;
                justify-content: center; /* centre horizontalement */
                align-items: center;     /* centre verticalement */
                flex-direction: column;  /* empile verticalement le contenu */
                font-family: Arial, sans-serif;
                background-color: #f0f4f8;
                color: #333;
                padding: 20px;
                box-sizing: border-box;
            }


            h2 {
                color: #005f73;
            }

            table {
                border-collapse: collapse;
                margin-bottom: 20px;
                box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            }

            table, th, td {
                border: 1px solid #ccc;
            }

            td {
                width: 30px;
                height: 30px;
                text-align: center;
                vertical-align: middle;
                font-weight: bold;
                font-size: 18px;
                cursor: default;
                user-select: none;
                transition: background-color 0.3s ease;
            }

            /* Couleurs selon l'état */
            td.hidden {
                background-color: #94d2bd;
                color: transparent; /* on cache le contenu pour hidden */
                cursor: pointer;
            }

            td.flagged {
                background-color: #ee6c4d;
                color: white;
            }

            td.revealed {
                background-color: #fff;
                color: #333;
            }

            td.revealed.bomb {
                background-color: #d62828;
                color: white;
            }

            form {
                margin-top: 20px;
                background: white;
                padding: 15px 20px;
                border-radius: 8px;
                box-shadow: 0 1px 5px rgba(0,0,0,0.1);
                max-width: 300px;
            }

            label {
                display: block;
                margin-bottom: 5px;
                font-weight: 600;
            }

            input[type="number"] {
                width: 100%;
                padding: 8px 6px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 14px;
            }

            button {
                background-color: #0077b6;
                color: white;
                border: none;
                padding: 10px 15px;
                margin-right: 10px;
                border-radius: 4px;
                font-weight: 600;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #023e8a;
            }

            button:focus {
                outline: 2px solid #90e0ef;
                outline-offset: 2px;
            }
        </style>
    </head>
    <body>
         <%@page import="pack.Grille"%>
         <%@page import="pack.Cell"%>

         <%
             Grille grille = (Grille) request.getAttribute("grille");
             if (grille != null) {
                 Cell[][] grid = grille.getGrid();
         %>
             <table border="1">
                 <%
                     for (int i = 0; i < grid.length; i++) {
                         out.println("<tr>");
                         for (int j = 0; j < grid[i].length; j++) {
                             Cell cell = grid[i][j];
                             String display = ""; 
                             if(cell.getState() == Cell.CellState.HIDDEN) {
                                 display = "-";
                             } else if(cell.getState() == Cell.CellState.FLAGGED) {
                                 display = "F";
                             } else if(cell.getState() == Cell.CellState.REVEALED) {
                                 if(cell.hasBomb()) {
                                     display = "*";
                                 } else {
                                     display = Integer.toString(cell.getBombsAround());
                                 }
                             }
                             out.println("<td>" + display + "</td>");
                         }
                         out.println("</tr>");
                     }
                 %>
             </table>
         <%
             } else {
                 out.println("La grille n'est pas disponible.");
             }
         %>
         
        <h2>Action sur une case</h2>
        <form action="./Controller" method="post">
            <label for="x">Coordonnée Y :</label>
            <input type="number" id="x" name="x" required><br><br>

            <label for="y">Coordonnée X :</label>
            <input type="number" id="y" name="y" required><br><br>

            <button type="submit" name="action" value="creuser">Creuser</button>
            <button type="submit" name="action" value="drapeau">Planter un drapeau</button>
        </form>
        <form action="./Controller" method="post">
            <button type="submit" name="clear" value="clear">Clear session</button>
        </form>
    </body>
</html>
