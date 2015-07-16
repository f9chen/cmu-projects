package dao;

import databeans.Enrollment;
import databeans.User;
import java.util.ArrayList;
import java.util.List;
import org.mybeans.factory.BeanFactory;
import org.mybeans.factory.BeanFactoryException;
import org.mybeans.factory.BeanTable;
import org.mybeans.factory.DuplicateKeyException;
import org.mybeans.factory.MatchArg;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

/**
 * Product Version: NetBeans IDE 7.1 (Build 201112071828)
 *
 * @author Fan Chen
 */
public class UserDAOFactoryImpl implements UserDAO {

    private BeanFactory<User> factory;
    private String jdbcDriver;
    private String jdbcURL;

    public UserDAOFactoryImpl(String jdbcDriver, String jdbcURL) throws MyDAOException {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;

        try {
            BeanTable<User> table = BeanTable.getSQLInstance(User.class, "fanc_user", jdbcDriver, jdbcURL);
            if (!table.exists()) {
                table.create("email");
            }
            factory = table.getFactory();
        } catch (BeanFactoryException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized User createUser(String fname, String lname, String email, String password) throws MyDAOException {
        try {
            Transaction.begin();
            User newUser = factory.create(email);
            newUser.setFname(fname);
            newUser.setLname(lname);
            newUser.setPassword(password);
            Transaction.commit();
            return newUser;
        } catch (DuplicateKeyException e) {
            throw new MyDAOException("An user with this name already exists.");
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized User lookup(String email) throws MyDAOException {
        try {
            return factory.lookup(email);
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized boolean addCourse(String email, String courseName, EnrollmentDAO enrollmentDAO) throws MyDAOException {
        try {
            enrollmentDAO.createEnrollment(email, courseName);
            return true;
        } catch (MyDAOException e) {
            return false;
        }
    }

    @Override
    public synchronized List<String> getMyCourse(String email) throws MyDAOException {
        BeanFactory<Enrollment> factory;
        try {
            BeanTable<Enrollment> table = BeanTable.getSQLInstance(Enrollment.class, "fanc_enrollment", jdbcDriver, jdbcURL);
            factory = table.getFactory();
            Enrollment[] enrollmentArrList = factory.match(MatchArg.equals("email", email));
            ArrayList<String> al = new ArrayList<String>();
            for (Enrollment enrollment : enrollmentArrList) {
                al.add(enrollment.getCourseName());
            }
            return al;
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized String getMyCourseListToHTML(String email) throws MyDAOException {
        return getMyCourseListToHTML(getMyCourse(email));
    }

    @Override
    public synchronized String getMyCourseListToSelectHTML(String email) throws MyDAOException {
        return getMyCourseListToSelectHTML(getMyCourse(email));
    }

    @Override
    public synchronized String getMyCourseNotesToHTML(String email, CourseDAO courseDAO) throws MyDAOException {

        String result = "";
        for (String courseName : getMyCourse(email)) {
            result += "<p>" + courseDAO.getSelectedCourseNoteToHTML(courseName) + "</p>";
        }
        System.out.println(result);
        return result;
    }

    public String getMyCourseListToHTML(List<String> myCourseList) {
        String result = "";
        for (String crs : myCourseList) {
            result += crs + "<br>";
        }
        return result;
    }

    public synchronized String getMyCourseListToSelectHTML(List<String> myCourseList) {
        String result = "";
        result += "<select class=\"dropdown\" name=\"courseSelected\">";
        for (String crs : myCourseList) {
            result += "<option>" + crs + "</option>";
        }
        result += "</select>";
        return result;
    }
}