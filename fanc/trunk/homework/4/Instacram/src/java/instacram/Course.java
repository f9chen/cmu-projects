/*@authour fanc
 * Course.java
 */
package instacram;

import java.util.LinkedList;

public class Course {

    private String courseName;
    private String createdBy;
    private LinkedList<Note> notesList = new LinkedList<Note>();

    public Course(String courseName, String createdBy) {
        this.courseName = courseName;
        this.createdBy = createdBy;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LinkedList<Note> getNotesList() {
        return notesList;
    }

    public void setNotesList(LinkedList<Note> notesList) {
        this.notesList = notesList;
    }

    @Override
    public String toString() {
        return getCourseName() + "\n";
    }

    public void addNote(Note note) {
        getNotesList().add(note);
    }

    public String getNotesListToHTML() {
        String result = "";
        result += "<p><a href=\"#\">" + courseName + "</a><br></p>";
        for (Note note : getNotesList()) {
            if (note.getCourseName().equals(getCourseName())) {
                result += "\"" + note.getContent() + "\"<br>by <a href=\"#\">" + note.getCreatedBy() + "</a>@ " + note.getTimestamp() + "<br><br>";
            }
        }
        return result;
    }
}
