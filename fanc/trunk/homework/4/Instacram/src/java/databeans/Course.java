/*@authour fanc
 * Course.java
 */
package databeans;

public class Course {

    private String courseName;
    private String createdBy;

    public Course() {
    }

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
}
