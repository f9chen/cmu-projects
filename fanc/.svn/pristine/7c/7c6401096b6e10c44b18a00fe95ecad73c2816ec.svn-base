package dao;

import databeans.*;
import java.util.List;

/**
 * Product Version: NetBeans IDE 7.1 (Build 201112071828)
 *
 * @author Fan Chen
 */
public interface UserDAO {

    public User createUser(String fname, String lname, String email, String password) throws MyDAOException;

    public User lookup(String email) throws MyDAOException;

    public boolean addCourse(String email, String courseName, EnrollmentDAO enrollmentDAO) throws MyDAOException;

    public List<String> getMyCourse(String email) throws MyDAOException;

    public String getMyCourseListToHTML(String email) throws MyDAOException;

    public String getMyCourseListToSelectHTML(String email) throws MyDAOException;

    public String getMyCourseNotesToHTML(String email, CourseDAO courseDAO) throws MyDAOException;
}
