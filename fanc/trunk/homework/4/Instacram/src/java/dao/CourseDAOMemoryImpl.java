//package dao;
//
//import instacram.Course;
//import instacram.Note;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Product Version: NetBeans IDE 7.1 (Build 201112071828)
// *
// * @author Fan Chen
// */
//public class CourseDAOMemoryImpl implements CourseDAO {
//
//    @Override
//    public String getNumCourse() throws MyDAOException {
//        return String.valueOf(getAllCourses().size());
//    }
//  public static final CourseDAOMemoryImpl INSTANCE = new CourseDAOMemoryImpl();
//  HashMap<String, Course> courseMap = new HashMap<String, Course>();
//
//  public Course createCourse(String courseName, String createdBy) throws MyDAOException {
//    if (courseMap.get(courseName) != null) {
//      throw new MyDAOException("A course with this name already exists: " + courseName);
//    }
//    Course newCourse = new Course(courseName, createdBy);
//    courseMap.put(newCourse.getCourseName(), newCourse);
//    return copy(newCourse);
//  }
//
//  @Override
//    public void addNote(String courseSelected, Note note, NoteDAO noteDAO) throws MyDAOException {
//      courseMap.get(courseSelected).addNote(note);
//    }
//
//  private Course copy(Course original) {
//    if (original == null) {
//      return null;
//    }
//
//    Course duplicate = new Course(original.getCourseName(), original.getCreatedBy());
//    return duplicate;
//  }
//
//  public List<String> getAllCourses() throws MyDAOException{
//    List<String> ll = new LinkedList<String>();
//    for(String courseName: courseMap.keySet()){
//      ll.add(courseName);
//    }
//    return ll;
//  }
//
//  public String getAllCoursesToHTML(String email) {
//    String result = "<ul class=\"nav nav-list\">";
//    for (String crs : courseMap.keySet()) {
//      result += "<li><a href=\"BrowseCourses?courseSelected="+crs+"&courseCreatedBy="+courseMap.get(crs).getCreatedBy() +"&email="+email+"\">"+crs+"</a></li>";
//    }
//    result += "</ul>";
//    return result;
//  }
//
//  public String getAllNotesListToHTML(){
//    String result="";
//    for(String courseName: courseMap.keySet()){
//      result+="<p>"+courseMap.get(courseName).getNotesListToHTML()+"</p>";
//    }
//    return result;
//  }
//
//
//  public String getSelectedCourseNoteToHTML(String courseSelected){
//    return courseMap.get(courseSelected).getNotesListToHTML();
//  }
//}
