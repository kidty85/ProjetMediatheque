/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

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
@WebServlet(name = "Admin", urlPatterns = {"/Admin", "/AdminAjout", "/AdminMembres", "/AdminEmprunts", "/AdminMedias", "/AdminDeconnexion"})
public class AdminServlet extends HttpServlet {

    @EJB
    private MediaFacadeLocal mediaFacade;
    @EJB
    private MembreFacadeLocal membreFacade;
    @EJB
    private EmpruntFacadeLocal empruntFacade;
    
    String admin = null;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String chemin = request.getServletPath();

        this.admin = (String) request.getSession().getAttribute("admin");
        if (this.admin == null) {
            request.setAttribute("login", "none");
            this.getServletContext().getRequestDispatcher("/jsp/bienvenue.jsp").forward(request, response);
        } else {
            switch (chemin) {
                case "/Admin":
                    request.setAttribute("admin", this.admin);
                    this.getServletContext().getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
                    break;

                case "/AdminAjout":
                    request.setAttribute("admin", this.admin);
                    this.getServletContext().getRequestDispatcher("/jsp/adminAjout.jsp").forward(request, response);
                    break;

                case "/AdminMembres":
                    List<Membre> membreList = this.membreFacade.findAll();
                    request.setAttribute("listeMembres", membreList);
                    request.setAttribute("admin", this.admin);
                    this.getServletContext().getRequestDispatcher("/jsp/adminMembre.jsp").forward(request, response);
                    break;

                case "/AdminEmprunts":
                    List<Emprunt> empruntList = this.empruntFacade.findAll();
                    request.setAttribute("listeEmprunts", empruntList);
                    request.setAttribute("admin", this.admin);
                    this.getServletContext().getRequestDispatcher("/jsp/adminEmprunt.jsp").forward(request, response);
                    break;

                case "/AdminMedias":
                    List<Media> mediaList = this.mediaFacade.findAll();
                    request.setAttribute("listeMedia", mediaList);
                    request.setAttribute("admin", this.admin);
                    this.getServletContext().getRequestDispatcher("/jsp/adminMedia.jsp").forward(request, response);
                    break;

                case "/AdminDeconnexion":
                    request.getSession().removeAttribute("admin");
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

        if (action.equals("Ajouter")) {
            String titre = request.getParameter("titre");
            String categorie = request.getParameter("categorie");
            String annee = request.getParameter("annee");
            String description = request.getParameter("description");
            int jours = Integer.parseInt(request.getParameter("jours"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            this.mediaFacade.insertMedia(titre, categorie, annee, description, jours, stock);

            request.getSession().setAttribute("admin", this.admin);
            request.getSession().setAttribute("ajout", "ok");
            response.sendRedirect("./AdminAjout");

        } else if (action.equals("rechercheMembre")) {
            String nom = request.getParameter("rechercheNom");
            String prenom = request.getParameter("recherchePrenom");
            if (!(nom.trim().isEmpty() && prenom.trim().isEmpty())) {

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
