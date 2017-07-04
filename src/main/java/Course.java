import javax.persistence.*;

/**
 * Created by mseidel on 30/06/2017.
 */
@Entity
@Table(name = "COURSES")
public class Course {

    private long courseId;
    private String courseName;

    public Course() {}

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    public long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column (name = "COURSE_NAME", nullable = false)
    public String getCourseName() {
        return courseName;
    }
}
