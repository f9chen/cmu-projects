/*
 * @author fanc
 * SystemController.java
 */
package instacram;

import java.util.HashMap;

public class SystemController {

    HashMap<String, User> userMap = new HashMap<String, User>();
    HashMap<String, Course> courseMap = new HashMap<String, Course>();
    public static final SystemController INSTANCE = new SystemController();
    public String courseSelected;
    public static String currentUser = "null";

    /*
     * public void init(){ User testUser = new User("Ryan", "Chen",
     * "r.chen@gmail.com", "Pa55word"); Course testCourse1 = new Course("c001",
     * "Web Application"); Course testCourse2 = new Course("c002", "Java");
     * testUser.addCourse(testCourse1); testUser.addCourse(testCourse2);
     * userMap.put(testUser.getEmail(),testUser);
     * courseMap.put(testCourse1.getCourseName(),testCourse1);
     * courseMap.put(testCourse2.getCourseName(),testCourse2);
     }
     */
    public boolean createUser(String fname, String lname, String email,
            String password) {
        try {
            User newUser = new User(fname, lname, email, password);
            userMap.put(newUser.getEmail(), newUser);
            System.out.println("user succesfully created!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean userSignIn(String email, String password) {
        try {
            if (userMap.get(email) != null) {
                for (String user : userMap.keySet()) {
                    System.out.println(user);
                }
                if (userMap.get(email).getPassword().equals(password)) {
                    userMap.get(email).setLoggedin(true);
                    System.out.println("successfully signned in");
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean createCourse(String courseName, String createdBy) {
        try {
            Course newCourse = new Course(courseName, createdBy);
            courseMap.put(newCourse.getCourseName(), newCourse);
            System.out.println("course succesfully created!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean joinCourse(String email, String courseName) {
        try {
            if (userMap.get(email) == null || courseMap.get(courseName) == null) {
                return false;
            }
            userMap.get(email).addCourse(courseName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getMyCourseListToString(String email) {
        if (userMap.get(email) != null) {
            return userMap.get(email).getMyCourseListToHTML();
        } else {
            return "";
        }

    }

    public String getAllCoursesToHTML() {
        String result = "<ul class=\"nav nav-list\">";
        for (String crs : courseMap.keySet()) {
            result += "<li><a href=\"BrowseCourses?courseSelected=" + crs + "&courseCreatedBy=" + courseMap.get(crs).getCreatedBy() + "&email=" + currentUser + "\">" + crs + "</a></li>";
        }
        result += "</ul>";
        return result;
    }

    public boolean isLoggedIn(String email) {
        return userMap.get(email).isLoggedin();
    }

    public boolean currentUserIsLoggedIn() {
        return isLoggedIn(currentUser);
    }

    public int getNumCourses() {
        return courseMap.size();
    }
}
