package dao;

import databeans.Course;
import databeans.Note;
import java.util.ArrayList;
import java.util.Arrays;
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
public class CourseDAOFactoryImpl implements CourseDAO {

    private BeanFactory<Course> factory;
    private String jdbcDriver;
    private String jdbcURL;

    public CourseDAOFactoryImpl(String jdbcDriver, String jdbcURL) throws MyDAOException {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;

        try {
            BeanTable<Course> table = BeanTable.getSQLInstance(Course.class, "fanc_course", jdbcDriver, jdbcURL);
            if (!table.exists()) {
                table.create("courseName");
            }
            factory = table.getFactory();
        } catch (BeanFactoryException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized Course createCourse(String courseName, String createdBy) throws MyDAOException {
        try {
            Transaction.begin();
            Course newCourse = factory.create(courseName);
            newCourse.setCreatedBy(createdBy);
            Transaction.commit();
            return newCourse;
        } catch (DuplicateKeyException e) {
            throw new MyDAOException("A course with this name already exists.");
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized List<String> getAllCourses() throws MyDAOException {
        try {
            Course[] courseArrList = factory.match();
            ArrayList<String> al = new ArrayList<String>();
            for (Course course : courseArrList) {
                al.add(course.getCourseName());
            }
            return al;
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized String getAllCoursesToHTML(String email) throws MyDAOException {
        String result = "<ul class=\"nav nav-list\">";
        for (String crs : getAllCourses()) {
            result += "<li><a href=\"BrowseCourses?courseSelected=" + crs + "&courseCreatedBy=" + lookup(crs).getCreatedBy() + "&email=" + email + "\">" + crs + "</a></li>";
        }
        result += "</ul>";
        return result;
    }

    @Override
    public synchronized String getSelectedCourseNoteToHTML(String courseSelected) throws MyDAOException {
        String result = "";
        result += "<p><a href=\"#\">" + courseSelected + "</a><br></p>";
        for (Note note : getSelectedCourseNotesList(courseSelected)) {
            if (note.getCourseName().equals(courseSelected)) {
                result += "\"" + note.getContent() + "\"<br>by <a href=\"#\">" + note.getCreatedBy() + "</a>@ " + note.getTimestamp() + "<br><br>";
            }
        }
        return result;
    }

    public synchronized List<Note> getSelectedCourseNotesList(String courseSelected) throws MyDAOException {
        BeanFactory<Note> factory;
        ArrayList<Note> al = new ArrayList<Note>();
        try {
            BeanTable<Note> table = BeanTable.getSQLInstance(Note.class, "fanc_note", jdbcDriver, jdbcURL);

            factory = table.getFactory();
            al = new ArrayList(Arrays.asList(factory.match(MatchArg.equals("courseName", courseSelected))));
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }

        return al;
    }

    @Override
    public synchronized void addNote(String courseSelected, Note note, NoteDAO noteDAO) throws MyDAOException {
        noteDAO.createNote(note.getContent(), courseSelected, note.getCreatedBy(), note.getTimestamp());
    }

    @Override
    public synchronized String getNumCourse() throws MyDAOException {
        return String.valueOf(getAllCourses().size());
    }

    public synchronized Course lookup(String courseName) throws MyDAOException {
        try {
            return factory.lookup(courseName);
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }
    }
}
