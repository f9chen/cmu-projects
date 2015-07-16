/*@author fanc
 * Register.java
 */
package servlet;

import dao.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

    static UserDAO userDAO;
    static CourseDAO courseDAO;

    @Override
    public void init() {
        initMemoryImpl();
    }

    public void initMemoryImpl() {
        userDAO = UserDAOMemoryImpl.INSTANCE;
        courseDAO = CourseDAOMemoryImpl.INSTANCE;
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String emailConfirm = request.getParameter("emailConfirm");
        String pwd = request.getParameter("password");
        String pwdConfirm = request.getParameter("passwordConfirm");

        RequestDispatcher view = null;

        if (fname != null && lname != null && email != null & pwd != null && email.equals(emailConfirm) && pwd.equals(pwdConfirm)) {
            try {
                userDAO.create(fname, lname, email, pwd);
                System.out.println("succesfully created!");
                view = request.getRequestDispatcher("welcome.jsp");
            } catch (MyDAOException e) {
            }
        } else {
            view = request.getRequestDispatcher("error.jsp");
        }
        view.forward(request, response);
    }
}
