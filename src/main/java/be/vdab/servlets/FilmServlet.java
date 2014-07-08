
package be.vdab.servlets;

import be.vdab.entities.Film;
import be.vdab.services.FilmService;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamil.laga
 */
@WebServlet("/Films.htm")
public class FilmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/films.jsp";
    private final FilmService filmService = new FilmService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int genreNr = Integer.parseInt(request.getParameter("genrenummer"));
        List<Film> films = filmService.findFilmsByGenre(genreNr);
        /*String filmFotosPad = this.getServletContext().getRealPath("/images");
        Set<Long> filmsMetFoto = new HashSet<Long>();
        for (Film film: films) {
            File file = new File(filmFotosPad + "/" + film.getFilmNr() + ".jpg");
            if (file.exists()) {
                filmsMetFoto.add(film.getFilmNr());
            }
        }*/
        request.setAttribute("films", films);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request,response);
        
    }
}
