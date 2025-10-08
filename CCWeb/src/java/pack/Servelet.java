package pack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author e2500138
 */
public class Servelet extends HttpServlet {

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
            
            String action = request.getParameter("action");
            String charr = request.getParameter("charr");
            String x1Param = request.getParameter("x1");
            String x2Param = request.getParameter("x2");
            String y1Param = request.getParameter("y1");
            String y2Param = request.getParameter("y2");
            
            
            
            HttpSession session = request.getSession(true);
            
            Dessin dessin;
            
            dessin = (Dessin) request.getSession().getAttribute("dessin");
            
            if(dessin == null){
                dessin = new Dessin();
            }
            
            if (action != null){
                if(action.equals("remplir")){
                    if(charr != null){
                        char charParsed = charr.charAt(0);
                        dessin.remplir(charParsed);
                    }
                   
                }
                if(action.equals("rectangle")){
                    int x1 = Integer.parseInt(x1Param);
                    int x2 = Integer.parseInt(x2Param);
                    int y1 = Integer.parseInt(y1Param);
                    int y2 = Integer.parseInt(y2Param);
                    char charParsed = charr.charAt(0);
                    
                    dessin.dessiner(x1, x2, y1, y2, charParsed);
                   
                }
            }
            
            
            request.getSession().setAttribute("dessin", dessin);
            
            request.setAttribute("dessin", dessin);
            
            request.getRequestDispatcher("/vue.jsp").forward(request, response);
            
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
