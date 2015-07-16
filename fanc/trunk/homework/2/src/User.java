/*
 * @author fanc
 * User.java
 */
package instacram;
import java.util.LinkedList;


public class User {
  private String fname;
  private String lname;
  private String email;
  private String password;
  private boolean loggedin = false;

  LinkedList<String> myCourseList = new LinkedList<String>();

  public User(String fname, String lname, String email, String password) {
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.password = password;
  }

  public boolean isLoggedIn(){
    return loggedin;
  }

  public void setLoggedIn(boolean loggedin){
    this.loggedin = loggedin;
  }

  public String getFname(){
      return fname;
  }
  
  public String getLname(){
      return lname;
  }
  
  public String getEmail(){
      return email;
  }
  
  public String getPassword(){
    return password;
  }

  public LinkedList getMyCourseList(){
    return myCourseList;
  }

  public void addCourse(String courseName){
    myCourseList.add(courseName);
  }

  public String getMyCourseListToHTML(){
    String result="";
    for(String crs: myCourseList){
      result+=crs+"<br>";
    }
    return result;
  }



}
