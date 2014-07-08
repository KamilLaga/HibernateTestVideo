/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.entities.Film;
import be.vdab.entities.Mandje;
import be.vdab.services.FilmService;
import be.vdab.services.ReservatieService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet("/rapport.htm")
public class RapportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "WEB-INF/JSP/rapport.jsp";
    //private final RapportDAO rapportDAO = new RapportDAO();
    private final FilmService filmService = new FilmService();
    private final ReservatieService reservatieService = new ReservatieService();
    private static final String MANDJE = "mandje";

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         Map<String,String> fouten = new HashMap<String,String>();
         if (session != null) {
            Mandje mandje = (Mandje) session.getAttribute(MANDJE);
            if (mandje != null) {
                List<Film> films = mandje.getFilms();
                int klantNr = Integer.parseInt(request.getParameter("klantNr"));
                for (Film film : films) {
                    int filmNr = film.getFilmNr();
                    Film f = filmService.read(filmNr);
                    if (f.isBeschikbaar() == true) {
                        reservatieService.maakReservatie(filmNr, klantNr); 
                    } else {
                        fouten.put("fout", film.getTitel());
                    }
                }
                
            }
            request.setAttribute("fouten", fouten);
            session.invalidate();
        }
         RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
         dispatcher.forward(request, response);
    }
}
