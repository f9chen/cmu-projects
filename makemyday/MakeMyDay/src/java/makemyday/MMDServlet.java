package makemyday;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fchen
 */
@WebServlet(name = "MMDServlet", urlPatterns = {"/MMDServlet"})
public class MMDServlet extends HttpServlet {

    /*
     * zip int radius int datepicker string activity string[]
     *
     */
    //MMDModel model = null;
    String zip = null;
    String radius = null;
    String datepicker = null;
    String[] cats = new String[3];
    Planner p = null;
    JSONBuilder jb = null;
    ArrayList<Event> eventList1 = new ArrayList<Event>();
    ArrayList<Event> eventList2 = new ArrayList<Event>();
    ArrayList<Route> routeList1 = new ArrayList<Route>();
    ArrayList<Route> routeList2 = new ArrayList<Route>();
    String jsonString = "";

    @Override
    public void init() {
        // model = new MMDModel();
        Planner p = null;
        JSONBuilder jb = null;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // get the search parameter if it exists
        zip = request.getParameter("zip");
        radius = request.getParameter("radius");
        datepicker = request.getParameter("date");
        String cat0 = request.getParameter("choice_1");
        String cat1 = request.getParameter("choice_2");
        String cat2 = request.getParameter("choice_3");
        cats = new String[]{cat0, cat1, cat2};
        if (zip != null) {

            // determine what type of device our user is
            //String ua = request.getHeader("User-Agent");

            // see if search parameter is present
            //  if () {
            // use model to do the search and choose the result view
            p = new Planner(zip, Integer.valueOf(radius), datepicker, cats);
            try {
                p.fetchEvent();
                eventList1 = p.plan1();
                eventList2 = p.plan2();
                routeList1 = p.getRouteList(eventList1);
                //  routeList2 = p.getRouteList(eventList2);
                jb = new JSONBuilder(eventList1, eventList2, routeList1, routeList2);
                jsonString = jb.build();
                System.out.println("==============\n" + jsonString);
                response.sendRedirect("/MakeMyDay/options.jsp");
            } catch (Exception e) {
                e.printStackTrace();
/*
                response.setContentType("text/html;charset=UTF-8");
       
                PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
        /*    out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("???"+jsonString);
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
            }

               // response.setContentType("text/json");
                //response.getWriter().println(jsonString);
               response.setContentType("application/json");
// Get the printwriter object from response to write the required json object to the output stream      
                PrintWriter out = response.getWriter();
// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
               out.print(jsonString);
                out.flush();
*/


                 
        }
        }  else{
                   RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                  view.forward(request, response);
            }


        }


}