package urbanRail;

import java.io.IOException;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UrbanRailServlet", urlPatterns = {"/UrbanRailServlet"})
public class UrbanRailServlet extends HttpServlet {
    /**
     * UrbanRailServlet will take in the input city and then use the UrbanRailodel.java
     * to search for the map.
     */

    UrbanRailModel urm = null;
    String search = null;

    @Override
    public void init() {
        urm = new UrbanRailModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get the search parameter if it exists
        search = request.getParameter("search");
        // determine what type of device our user is
        String ua = request.getHeader("User-Agent");

        // see if search parameter is present
        if(search != null) {
                 // use model to do the search and choose the result view
                 urm.doSearch(search);
                 request.setAttribute("pictureURL", urm.getPrictureURL());
                 request.setAttribute("websiteURL", urm.getWebsiteURL());
                 request.setAttribute("cityTag", urm.getCityTag());
                 RequestDispatcher view = request.getRequestDispatcher("result.jsp");
                 view.forward(request, response);
        }
        else {
            // no search parameter so choose the prompt view
            RequestDispatcher view = request.getRequestDispatcher("prompt.jsp");
            view.forward(request, response);
      }
    }
}