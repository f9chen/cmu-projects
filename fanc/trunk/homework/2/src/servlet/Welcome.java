/*
 * @author fanc
 * Welcome.java
 */
package servlet;

import dao.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet {

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
        RequestDispatcher view = null;

        HttpSession session = request.getSession();
        if(session.getAttribute("login")==null){
            session.setAttribute("login", false);
        }

        try {
            if (!(Boolean) session.getAttribute("login")) {
                String email = request.getParameter("email");
                String pwd = request.getParameter("pwd");
                if (userDAO.lookup(email) != null) {
                    if (userDAO.lookup(email).getPassword().equals(pwd)) {
                        session.setAttribute("login", true);
                        //controller.currentUser = email;
                        request.setAttribute("courseList", userDAO.getMyCourseListToHTML(email));
                        view = request.getRequestDispatcher("your-courses.jsp");
                    }
                    
                }
                else{//login failure or user not exists
                    request.setAttribute("message","password not correct or user does not exists");
                         view = request.getRequestDispatcher("welcome.jsp");
                    }
            }
        } catch (MyDAOException e) {
        }
 view.forward(request, response);
    }
}
