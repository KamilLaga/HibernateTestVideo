

package be.vdab.servlets;


import be.vdab.entities.Klant;
import be.vdab.entities.Mandje;
import be.vdab.services.KlantService;

import java.io.IOException;
import java.util.List;
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
@WebServlet("/Bevestigen.htm")
public class BevestigenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "WEB-INF/JSP/bevestigen.jsp";
    private final KlantService klantService = new KlantService();
    private static final String MANDJE="mandje";
    private static final String KLANT = "klant";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         if (session != null) {
            Mandje mandje = (Mandje) session.getAttribute(MANDJE);
            String familienaam = request.getParameter("Familienaam");
            List<Klant> klanten = klantService.findByFamilienaam(familienaam);
            request.setAttribute("klanten", klanten);
            session.setAttribute(KLANT, klanten);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
