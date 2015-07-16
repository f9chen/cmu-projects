package dao;

import databeans.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Product Version: NetBeans IDE 7.1 (Build 201112071828)
 *
 * @author Fan Chen
 */
public class UserDAOSQLImpl implements UserDAO {

    private List<Connection> connectionPool = new ArrayList<Connection>();
    private String jdbcDriver;
    private String jdbcURL;

    public UserDAOSQLImpl(String jdbcDriver, String jdbcURL) {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;

        try {
            createTable();
        } catch (MyDAOException e) {
            // Ignore ... if thrown assume it's because table already exists
            // If it's some other problem we'll fail later on
        }
    }

    @Override
    public synchronized boolean addCourse(String email, String courseName, EnrollmentDAO enrollmentDAO) {
        try {
            enrollmentDAO.createEnrollment(email, courseName);
            return true;
        } catch (MyDAOException e) {
            return false;
        }
    }

    @Override
    public synchronized User createUser(String fname, String lname, String email, String password) throws MyDAOException {

        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO fanc_user (fname,lname,email,password) VALUES (?,?,?,?)");

            User newUser = new User(fname, lname, email, password);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, email);
            pstmt.setString(4, newUser.getPassword());
            int count = pstmt.executeUpdate();
            if (count != 1) {
                throw new SQLException("Insert updated " + count + " rows");
            }

            pstmt.close();
            releaseConnection(con);
            return newUser;

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) { /* ignore */ }
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized List<String> getMyCourse(String email) throws MyDAOException {

        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select courseName from fanc_enrollment where email =?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            List<String> list = new ArrayList<String>();
            while (rs.next()) {
                list.add(rs.getString("courseName"));
            }
            rs.close();
            pstmt.close();
            releaseConnection(con);

            return list;

        } catch (SQLException e) {
            throw new AssertionError(e);
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

    @Override
    public synchronized User lookup(String email) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM fanc_user WHERE email=?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            User user;
            if (!rs.next()) {
                user = null;
            } else {
                user = new User(rs.getString("fname"), rs.getString("lname"), rs.getString("email"), rs.getString("password"));
            }

            rs.close();
            pstmt.close();
            releaseConnection(con);
            return user;

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) { /* ignore */ }
            throw new MyDAOException(e);
        }
    }

    public synchronized void setPassword(String email, String password) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("UPDATE user SET password=? WHERE email=?");
            pstmt.setString(1, password);
            pstmt.setString(2, email);
            int count = pstmt.executeUpdate();
            pstmt.close();

            if (count == 0) {
                throw new MyDAOException("No such user: " + email);
            }
            if (count > 1) {
                throw new MyDAOException("Update modified " + count + " rows!");
            }

            releaseConnection(con);

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) { /* ignore */ }
            if (e instanceof MyDAOException) {
                throw (MyDAOException) e;
            }
            throw new MyDAOException(e);
        }
    }

    private synchronized void createTable() throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE fanc_user (fname VARCHAR(255) NOT NULL,lname VARCHAR(255) NOT NULL,email VARCHAR(255) NOT NULL, password VARCHAR(255), PRIMARY KEY(email))");
            stmt.close();

            releaseConnection(con);

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) { /* ignore */ }
            throw new MyDAOException(e);
        }
    }

    private synchronized Connection getConnection() throws MyDAOException {
        if (connectionPool.size() > 0) {
            return connectionPool.remove(connectionPool.size() - 1);
        }

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new MyDAOException(e);
        }

        try {
            return DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            throw new MyDAOException(e);
        }
    }

    private synchronized void releaseConnection(Connection con) {
        connectionPool.add(con);
    }

    public synchronized String getMyCourseListToHTML(List<String> myCourseList) {
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
