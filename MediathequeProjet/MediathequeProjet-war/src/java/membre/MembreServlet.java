/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membre;

import entite.Emprunt;
import entite.EmpruntFacadeLocal;
import entite.Media;
import entite.MediaFacadeLocal;
import entite.Membre;
import entite.MembreFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "Membre", urlPatterns = {"/Membre", "/MembreMedias", "/MembreMedia", "/MembreEmprunts", "/MembreDeconnexion"})
public class MembreServlet extends HttpServlet {
    @EJB
    private EmpruntFacadeLocal empruntFacade;
    @EJB
    private MembreFacadeLocal membreFacade;
    @EJB
    private MediaFacadeLocal mediaFacade;
   
    
    Membre membre;

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
        System.out.println("dans la servlet membre");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String chemin = request.getServletPath();

        String email = (String) request.getSession().getAttribute("email");
        if (email == null) {
            request.setAttribute("login", "none");
            this.getServletContext().getRequestDispatcher("/jsp/bienvenue.jsp").forward(request, response);
        } else {
            this.membre = this.membreFacade.findbyEmail(email);
            switch (chemin) {
                case "/Membre":
                    request.setAttribute("membre", this.membre);
                    this.getServletContext().getRequestDispatcher("/jsp/membre.jsp").forward(request, response);
                    break;
                case "/MembreMedias":
                    List<Media> mediaList = this.mediaFacade.findAll();
                    List<Media> mediaEmpruntList = this.empruntFacade.findMediaEmpruntesEnCours(this.membre, mediaList);
                    request.setAttribute("listeEmpruntMedia", mediaEmpruntList);
                    request.setAttribute("listeMedia", mediaList);
                    request.setAttribute("membre", this.membre);
                    this.getServletContext().getRequestDispatcher("/jsp/membreMedias.jsp").forward(request, response);
                    break;
                case "/MembreEmprunts":
                    List<Emprunt> empruntList = this.empruntFacade.findEmpruntsEnCours(this.membre);
                    request.setAttribute("membre", this.membre);
                    request.setAttribute("listeEmprunt", empruntList);
                    this.getServletContext().getRequestDispatcher("/jsp/membreEmprunts.jsp").forward(request, response);
                    break;
                case "/MembreDeconnexion":
                    request.getSession().removeAttribute("email");
                    response.sendRedirect("./Accueil");
                    break;
                default: ;
            }
        }
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
        PrintWriter out = response.getWriter();
        String action = request.getParameter("actionButton");

        System.out.println("media OK");
        String[] params = action.split("_");
        if (params[0].equals("Emprunter")) {
            if (this.empruntFacade.estEmpruntAutorise(this.membre.getMembreId())) {
                this.empruntFacade.insertEmprunt(this.membre.getMembreId(), Integer.parseInt(params[1]));
                request.getSession().setAttribute("emprunt", "ok");
                response.sendRedirect("./MembreMedias");
            }
        } else if (params[0].equals("Rendre")) {
            this.empruntFacade.deleteEmprunt(Integer.parseInt(params[1]));
            request.getSession().setAttribute("rendre", "ok");
            response.sendRedirect("./MembreEmprunts");
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
