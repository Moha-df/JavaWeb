/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author e2500138
 */
public class display extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            HttpSession session = request.getSession(true);
            
            ArrayList<String[]> tabStudents = null;
            if (session != null) {
                tabStudents = (ArrayList<String[]>) session.getAttribute("brrbrr");
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>TODO supply a title</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #121212;"); // fond très sombre
            out.println("    color: #e0e0e0;"); // texte clair");
            out.println("    padding: 40px;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    flex-direction: column;");
            out.println("    height: 100vh;");
            out.println("}");
            out.println("table {");
            out.println("    border-collapse: collapse;");
            out.println("    width: 80%;");
            out.println("    max-width: 600px;");
            out.println("    margin-bottom: 30px;");
            out.println("    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.7);");
            out.println("    border-radius: 8px;");
            out.println("    overflow: hidden;");
            out.println("    background-color: #1e1e1e;");
            out.println("}");
            out.println("th, td {");
            out.println("    padding: 12px 15px;");
            out.println("    text-align: left;");
            out.println("    border-bottom: 1px solid #333;");
            out.println("}");
            out.println("th {");
            out.println("    background-color: #333;");
            out.println("    color: #fff;");
            out.println("    font-weight: bold;");
            out.println("}");
            out.println("tr:nth-child(even) {");
            out.println("    background-color: #2c2c2c;");
            out.println("}");
            out.println("tr:hover {");
            out.println("    background-color: #444;");
            out.println("}");
            out.println("form {");
            out.println("    background-color: #1e1e1e;");
            out.println("    padding: 30px 40px;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.7);");
            out.println("    width: 300px;");
            out.println("    margin-top: 30px;");
            out.println("}");
            out.println("div {");
            out.println("    text-align: center;");
            out.println("    font-size: 24px;");
            out.println("    margin-bottom: 20px;");
            out.println("    font-weight: bold;");
            out.println("    color: #ccc;");
            out.println("}");
            out.println("input[type=\"number\"],");
            out.println("select,");
            out.println("input[type=\"text\"] {");
            out.println("    width: 100%;");
            out.println("    padding: 10px;");
            out.println("    margin-top: 10px;");
            out.println("    margin-bottom: 20px;");
            out.println("    border: 1px solid #555;");
            out.println("    border-radius: 5px;");
            out.println("    box-sizing: border-box;");
            out.println("    background-color: #333;");
            out.println("    color: #eee;");
            out.println("}");
            out.println("input[type=\"submit\"] {");
            out.println("    background-color: #4B0082;");
            out.println("    color: white;");
            out.println("    border: none;");
            out.println("    padding: 12px;");
            out.println("    width: 100%;");
            out.println("    border-radius: 5px;");
            out.println("    cursor: pointer;");
            out.println("    font-size: 16px;");
            out.println("    transition: background-color 0.3s ease;");
            out.println("}");
            out.println("input[type=\"submit\"]:hover {");
            out.println("    background-color: #9370DB;");
            out.println("}");
            out.println(".resultat {");
            out.println("    margin-top: 50px;");
            out.println("    font-size: 24px;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            if (tabStudents == null || tabStudents.isEmpty()) {
                out.println("<p>Aucun étudiant trouvé.</p>");
            } else {
                out.println("<table border='1'>");
                out.println("<tr><th>Prénom</th><th>Nom</th><th>Notes</th></tr>");
                for (String[] student : tabStudents) {
                    out.println("<tr>");
                    out.println("<td>" + student[0] + "</td>");
                    out.println("<td>" + student[1] + "</td>");
                    out.println("<td>" + student[2] + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
            out.println("<form action=\"./newStudent\" method=\"get\">");
            out.println("First name : <input type=\"text\" name=\"firstname\"> <br>");
            out.println("Last name : <input type=\"text\" name=\"lastname\"> <br>");
            out.println("Grades : <input type=\"number\" name=\"grades\"> <br>");
            out.println("<input type=\"submit\" value=\"Send\">");
            out.println("</form>");
            out.println("<form action=\"./deleteAllStudent\" method=\"get\">");
            out.println("<input type=\"submit\" value=\"Delete\">");
            out.println("</form>");
            
            out.println("</body></html>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
