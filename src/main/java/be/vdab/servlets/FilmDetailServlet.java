/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.entities.Film;
import be.vdab.entities.Mandje;

import be.vdab.services.FilmService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kamil.laga
 */
@WebServlet("/Films/Detail.htm")
public class FilmDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/filmdetail.jsp";
    private static final String REDIRECT_URL = "/mandje.htm";
    private static final String MANDJE = "mandje";  
    private final FilmService filmService = new FilmService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int filmNr = Integer.parseInt(request.getParameter("filmNummer"));
        Film film = filmService.read(filmNr);
        request.setAttribute("filmDetail", film);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request,response);
    }

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            HttpSession session= request.getSession();
            int filmNr = Integer.parseInt(request.getParameter("filmNummer"));
            if (session != null) {
               Mandje mandje = (Mandje) session.getAttribute(MANDJE);  
                if (mandje == null) {                                         
                    mandje = new Mandje();                       
                    try {
                        Film film = filmService.read(filmNr);
                        mandje.addFilm(film);
                        session.setAttribute(MANDJE, mandje);                     
                    } catch (Exception ex) {
                }
            } 
        }
        response.sendRedirect(REDIRECT_URL);
    }
}
