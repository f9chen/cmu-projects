package databeans;

import instacram.*;

/**
 * Product Version: NetBeans IDE 7.1 (Build 201112071828)
 *
 * @author Fan Chen
 */
public class Enrollment {

    private String email;
    private String courseName;

    public Enrollment() {
    }

    public Enrollment(String email, String courseName) {
        this.email = email;
        this.courseName = courseName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
