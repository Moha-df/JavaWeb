package pack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import pack.Grille;
import pack.Cell;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author e2500138
 */
public class Controller extends HttpServlet {

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
            String xParam = request.getParameter("x");
            String yParam = request.getParameter("y");
            
            String clear = request.getParameter("clear");
            
            Grille grille;
            
            if (action != null && xParam != null && yParam != null) {
                
                grille = (Grille) request.getSession().getAttribute("grille");

                if (grille == null) {
                    grille = new Grille(); // ou lève une erreur, selon le cas
                }

                int x = Integer.parseInt(xParam);
                int y = Integer.parseInt(yParam);
                
                Cell cell = grille.getCell(x, y);
                
                
                // Aplliquer l'action
                if (action.equals("creuser")) {
                   if (cell.getState() == Cell.CellState.HIDDEN) {
                        cell.setState(Cell.CellState.REVEALED);
                        // (Optionnel) tu peux aussi ajouter ici une logique de "révélation automatique"
                        // des cases vides autour si bombsAround == 0
                    }
                } else if (action.equals("drapeau")) {
                    if (cell.getState() == Cell.CellState.HIDDEN) {
                        cell.setState(Cell.CellState.FLAGGED);
                    } else if (cell.getState() == Cell.CellState.FLAGGED) {
                        cell.setState(Cell.CellState.HIDDEN);
                    }
                }
                
                request.getSession().setAttribute("grille", grille);
                
                // Mettre la grille dans l'attribut request
                request.setAttribute("grille", grille);

                // Forward vers la JSP
                request.getRequestDispatcher("/Vue.jsp").forward(request, response);
                
            }else if(clear != null){
                // Création d'une nouvelle grille
                grille = new Grille();

                // Réinitialise la session
                request.getSession().setAttribute("grille", grille);
                request.setAttribute("grille", grille);

                // Retour à la JSP
                request.getRequestDispatcher("/Vue.jsp").forward(request, response);
                
            }else {
                // Première visite : créer une nouvelle grille ou la récuperer de la session
                grille = (Grille) request.getSession().getAttribute("grille");
                
                if(grille == null){
                    grille = new Grille();
                }
                
                request.getSession().setAttribute("grille", grille);
                
                // Mettre la grille dans l'attribut request
                request.setAttribute("grille", grille);

                // Forward vers la JSP (remplace "/vue.jsp" par le chemin réel de ta JSP)
                request.getRequestDispatcher("/Vue.jsp").forward(request, response);
            }
            

            
            
            
            
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
    