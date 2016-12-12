/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accueil;

import entite.MembreFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quangminhnguyen
 */
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {

    @EJB
    private MembreFacadeLocal membreFacade;

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
        this.getServletContext().getRequestDispatcher("/jsp/bienvenue.jsp").forward(request, response);
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
        String button = request.getParameter("actionButton");
        String email;
        String mdp;
        String mdpConfirm;
        String nom;
        String prenom;
        PrintWriter out = response.getWriter();
        
        if (button.equals("connexion")) {
            email = request.getParameter("mailConnexion");
            mdp = request.getParameter("mdpConnexion");
            if (this.membreFacade.checkLogin(email, mdp)) {
                if (this.membreFacade.isAdmin(email)) {
                    request.getSession().setAttribute("admin", "Administrateur");
                    response.sendRedirect("./Admin");
                } else {
                    request.getSession().setAttribute("email", email);
                    response.sendRedirect("./Membre");
                }
            }else{
                request.setAttribute("message", "incorrect");
                request.getRequestDispatcher("/jsp/bienvenue.jsp").forward(request, response);;
            }
        }
        if (button.equals("inscription")) {
            nom = request.getParameter("nomInscription");
            prenom = request.getParameter("prenomInscription");
            email = request.getParameter("mailInscription");
            mdp = request.getParameter("mdpInscription");
            mdpConfirm = request.getParameter("mdpConfirmInscription");
            if (this.membreFacade.checkMail(email)) {
                this.membreFacade.insertMembre(nom, prenom, email, mdp);
                request.setAttribute("message", "inscription");
                request.getRequestDispatcher("/jsp/bienvenue.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "mailExistant");
                request.getRequestDispatcher("/jsp/bienvenue.jsp").forward(request, response);
            }
        }
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
