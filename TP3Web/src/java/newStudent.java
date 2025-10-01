/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author e2500138
 */
public class newStudent extends HttpServlet {

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
            
            
            
            
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String grades = request.getParameter("grades");
            
           
            
            
            HttpSession session = request.getSession(true);
            
            /*
            Boolean nouvelleSession= session.isNew();

            ArrayList<String[]> tabStudents;
            if(nouvelleSession){
                tabStudents = new ArrayList<String[]>();
                //ArrayList<String[]> tabStudents = ( ArrayList<String[]>) session.getAttribute("studentObj");
                tabStudents.add(new String[]{firstname, lastname, grades});
                session.setAttribute("brrbrr", tabStudents);
            }else{
                tabStudents = ( ArrayList<String[]>) session.getAttribute("brrbrr");
                tabStudents.add(new String[]{firstname, lastname, grades});
                session.setAttribute("brrbrr", tabStudents);
            }*/

            
            
            ArrayList<String[]> tabStudents = ( ArrayList<String[]>) session.getAttribute("brrbrr");
            if (tabStudents == null){
                tabStudents = new ArrayList<String[]>();
            }
            tabStudents.add(new String[]{firstname, lastname, grades});
            session.setAttribute("brrbrr", tabStudents);
            
            // Pour des logs
            /*
            for (String[] student : tabStudents) {
                System.out.println("Student: " + Arrays.toString(student));
            }
            */
            
            response.sendRedirect("display");
            
            

            

            
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet newStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newStudent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
            
            
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
