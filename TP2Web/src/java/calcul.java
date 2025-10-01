/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author e2500138
 */
public class calcul extends HttpServlet {

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
        
        /////http://localhost:8080/TP2Web/calcul?nombre1=&nombre2=&operand=%2B
        ///
        ///
            
            String num1 = request.getParameter("nombre1");
            String num2 = request.getParameter("nombre2");
            String operand = request.getParameter("operand");
            
            int res = 0;
            
            if (num1 == null || num2 == null || operand == null ||
                num1.isEmpty() || num2.isEmpty()) {
                res = 404;
            }else{
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);

                res = 0;

                if(operand.equals("+")){
                    res = n1 + n2;
                }else if(operand.equals("-")){
                    res = n1 - n2;
                }else if(operand.equals("/")){
                    if(n2 == 0){
                        res = 0;
                    }else{
                        res = n1 / n2;
                    }
                }else if(operand.equals("*")){
                    res = n1 * n2;
                }else {
                    res = 99999;
                }
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
            out.println("    background-color: #f4f4f4;");
            out.println("    padding: 40px;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    flex-direction: column;");
            out.println("    height: 100vh;");
            out.println("}");
            out.println("form {");
            out.println("    background-color: white;");
            out.println("    padding: 30px 40px;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
            out.println("    width: 300px;");
            out.println("}");
            out.println("div {");
            out.println("    text-align: center;");
            out.println("    font-size: 24px;");
            out.println("    margin-bottom: 20px;");
            out.println("    font-weight: bold;");
            out.println("    color: #333;");
            out.println("}");
            out.println("input[type=\"number\"],");
            out.println("select {");
            out.println("    width: 100%;");
            out.println("    padding: 10px;");
            out.println("    margin-top: 10px;");
            out.println("    margin-bottom: 20px;");
            out.println("    border: 1px solid #ccc;");
            out.println("    border-radius: 5px;");
            out.println("    box-sizing: border-box;");
            out.println("}");
            out.println("input[type=\"submit\"] {");
            out.println("    background-color: #4CAF50;");
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
            out.println("    background-color: #45a049;");
            out.println("}");
            out.println(".resultat {");
            out.println("    margin-top: 50px;");
            out.println("    font-size: 24px;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"./calcul\" method=\"get\">");
            out.println("Number1 : <input type=\"number\" name=\"nombre1\"> <br>");
            out.println("Number2 : <input type=\"number\" name=\"nombre2\"> <br>");
            out.println("<select name=\"operand\">");
            out.println("<option value=\"+\"> + </option>");
            out.println("<option value=\"-\"> - </option>");
            out.println("<option value=\"*\"> * </option>");
            out.println("<option value=\"/\"> / </option>");
            out.println("</select>");
            out.println("<input type=\"submit\" value=\"Calculate\">");
            out.println("</form>");
            out.println("<div class=\"resultat\" id=\"resultat\">" + res + "</div>");
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
