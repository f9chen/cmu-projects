/*
 * @author fanc
 * JoinCourse.java
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

public class JoinCourse extends HttpServlet {
  static SystemController controller;

  @Override
    public void init() {
      controller = SystemController.INSTANCE;
    }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    String email = request.getParameter("email");
    RequestDispatcher view = null;

    String courseSelected= request.getParameter("courseSelected");
    controller.joinCourse(email, courseSelected);
    request.setAttribute("email", email);
    view = request.getRequestDispatcher("YourCourses?email="+email);
    view.forward(request, response);
  }
}
