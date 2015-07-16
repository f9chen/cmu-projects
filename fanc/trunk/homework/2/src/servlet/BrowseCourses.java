/*
 * @author fanc
 * BrowseCourses.java
 */
package servlet;

import instacram.SystemController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BrowseCourses extends HttpServlet {
  static SystemController controller;

  @Override
    public void init() {
      controller = SystemController.INSTANCE;
    }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    RequestDispatcher view = null;

    String courseSelected = request.getParameter("courseSelected");
    String courseCreatedBy = request.getParameter("courseCreatedBy");
    String email = request.getParameter("email");

    if(email ==null||email.equals("null")){
      request.setAttribute("message", "Sorry! Please log in!");
      view = request.getRequestDispatcher("welcome.jsp");
    }
    else{
      if(controller.currentUserIsLoggedIn()){
        request.setAttribute("courseSelected", courseSelected);
        request.setAttribute("courseCreatedBy", courseCreatedBy);
        view = request.getRequestDispatcher("browse-courses.jsp");
      }
    }
    request.setAttribute("email", email);
    view.forward(request, response);
  }
}
