/*@author fanc
 * YourCourse.java
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

public class YourCourses extends HttpServlet {

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

    System.out.println(email);
    if (email == null||email.equals("null")) {
      request.setAttribute("message", "Sorry! Please log in!");
      view = request.getRequestDispatcher("welcome.jsp");
    } else {
      if (controller.currentUserIsLoggedIn()) {
        System.out.println(controller.getMyCourseListToString(email));

        request.setAttribute("courseList", controller.getMyCourseListToString(email));
        request.setAttribute("email", email);
        view = request.getRequestDispatcher("your-courses.jsp");
      }
    }
    view.forward(request, response);
  }
}
