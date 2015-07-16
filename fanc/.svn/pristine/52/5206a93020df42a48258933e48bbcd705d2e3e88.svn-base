package dao;

import databeans.Course;
import databeans.Note;
import java.util.List;

/**
 * Product Version: NetBeans IDE 7.1 (Build 201112071828)
 *
 * @author Fan Chen
 */
public interface CourseDAO {

    public Course createCourse(String courseName, String createdBy) throws MyDAOException;

    public List<String> getAllCourses() throws MyDAOException;

    public String getAllCoursesToHTML(String email) throws MyDAOException;

    public String getSelectedCourseNoteToHTML(String courseSelected) throws MyDAOException;

    public void addNote(String courseSelected, Note note, NoteDAO noteDAO) throws MyDAOException;

    public String getNumCourse() throws MyDAOException;
}
