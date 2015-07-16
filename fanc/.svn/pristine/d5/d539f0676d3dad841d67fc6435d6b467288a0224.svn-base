/*@author fanc
 * Register.java
 */
package servlet;

import dao.*;
import formbeans.RegistrationForm;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mybeans.forms.FormBeanFactory;

public class Register extends HttpServlet {
     String email;

    private static FormBeanFactory<RegistrationForm> formBeanFactory =
            FormBeanFactory.getInstance(RegistrationForm.class, "<>\"");
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
        RequestDispatcher view = null;
        RegistrationForm form = formBeanFactory.create(request);
        request.setAttribute("form", form);
        if (form.getValidationErrors().size() > 0) {
                view = request.getRequestDispatcher("error.jsp");
                view.forward(request, response);
                return;
            }
        try {
            userDAO.createUser(form.getFname(), form.getLname(), form.getEmail(), form.getPassword());
            view = request.getRequestDispatcher("welcome.jsp");
            view.forward(request, response);
           
        } catch (MyDAOException e) {

            view = request.getRequestDispatcher("error.jsp");
            view.forward(request, response);

        }
    }
}
