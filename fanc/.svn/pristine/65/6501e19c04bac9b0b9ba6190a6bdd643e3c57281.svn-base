/*
 * @author fanc
 * Logoff.java
 */
package servlet;

import instacram.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logoff extends HttpServlet {

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

    if (email != null&&!email.equals("null")  ) {
      if (controller.isLoggedIn(email)) {
        controller.currentUser = null;
        view = request.getRequestDispatcher("welcome.jsp");
      }
    } else {
      request.setAttribute("email", email);
      request.setAttribute("message", "Not logged in yet.");
      view = request.getRequestDispatcher("welcome.jsp");
    }
    view.forward(request, response);
  }
}
