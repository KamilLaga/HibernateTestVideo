/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.entities.Mandje;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mandje/verwijderen.htm")
public class MandjeVerwijderenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW ="/mandje.htm";
    private static final String MANDJE="mandje";
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
    
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         if (session != null) {
            Mandje mandje = (Mandje) session.getAttribute(MANDJE);
            
             if (request.getParameterValues("filmNr") != null) {
                 try {
                     for (String filmNrAlsString : request.getParameterValues("filmNr")) {
                         int filmNr= Integer.parseInt(filmNrAlsString);
                         mandje.removeByFilmNr(filmNr);                         
                     }
                 } catch (NumberFormatException ex) {ex.getMessage();}
             }
             
         }
         response.sendRedirect(request.getContextPath() + VIEW);
    }

    

}
