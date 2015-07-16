/*
 * @author fanc
 * JoinCourse.java
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

public class JoinCourse extends HttpServlet {

    static UserDAO userDAO;
    static CourseDAO courseDAO;
    static NoteDAO noteDAO;
    static EnrollmentDAO enrollmentDAO;
    static SearchDAO searchDAO;

    @Override
    public void init() {
        //initMemoryImpl();
        //initSQLImpl();
        initFactoryImpl();
    }

//    public void initMemoryImpl() {
//        userDAO = UserDAOMemoryImpl.INSTANCE;
//        courseDAO = CourseDAOMemoryImpl.INSTANCE;
//
//    }
    public void initSQLImpl() {
        String jdbcDriverName = getInitParameter("jdbcDriverName");
        String jdbcURL = getInitParameter("jdbcURL");

        userDAO = new UserDAOSQLImpl(jdbcDriverName, jdbcURL);
        courseDAO = new CourseDAOSQLImpl(jdbcDriverName, jdbcURL);
        noteDAO = new NoteDAOSQLImpl(jdbcDriverName, jdbcURL);
        enrollmentDAO = new EnrollmentDAOSQLImpl(jdbcDriverName, jdbcURL);
        searchDAO = new SearchDAOSQLImpl(jdbcDriverName, jdbcURL);

    }

    public void initFactoryImpl() {
        String jdbcDriverName = getInitParameter("jdbcDriverName");
        String jdbcURL = getInitParameter("jdbcURL");
        try {
            userDAO = new UserDAOFactoryImpl(jdbcDriverName, jdbcURL);
            courseDAO = new CourseDAOFactoryImpl(jdbcDriverName, jdbcURL);
            noteDAO = new NoteDAOFactoryImpl(jdbcDriverName, jdbcURL);
            enrollmentDAO = new EnrollmentDAOFactoryImpl(jdbcDriverName, jdbcURL);
            searchDAO = new SearchDAOSQLImpl(jdbcDriverName, jdbcURL);
        } catch (MyDAOException e) {
        }

    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // String email = request.getParameter("email");

        RequestDispatcher view = null;
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        try {
            String courseSelected = request.getParameter("courseSelected");
            userDAO.addCourse(email, courseSelected, enrollmentDAO);
            // request.setAttribute("email", email);
            request.setAttribute("notes", userDAO.getMyCourseNotesToHTML(email, courseDAO));
            request.setAttribute("courseList", userDAO.getMyCourseListToHTML(email));
            view = request.getRequestDispatcher("YourCourses?email=" + email);
            session.setAttribute("login", true);
        } catch (MyDAOException e) {
        }
        view.forward(request, response);
    }
}
