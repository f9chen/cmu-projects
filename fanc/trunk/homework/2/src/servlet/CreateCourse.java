/*
 * @author fanc
 * CreateCourse.java
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

public class CreateCourse extends HttpServlet {

  static SystemController controller;

  @Override
    public void init() {
      controller = SystemController.INSTANCE;
    }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    String courseName = request.getParameter("courseName");
    String email = request.getParameter("email");

    RequestDispatcher view = null;
    String message="";

    if(email ==null||email.equals("null")){
      request.setAttribute("message", "Sorry! Please log in!");
      view = request.getRequestDispatcher("welcome.jsp");
    }
    else{
      if(controller.currentUserIsLoggedIn()) {
        if (courseName != null) {
          if (controller.createCourse(courseName, email)) {
            message = "Course has been created successfully!";
          } else {
            message = "Sorry your course is not created. Please check your input and try again!";
          }
        }

        request.setAttribute("message", message);
        request.setAttribute("email", email);
        view = request.getRequestDispatcher("create-a-course.jsp");
      } 
    } 
    view.forward(request, response);
  }
}
