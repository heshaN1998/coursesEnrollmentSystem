package lk.heshan.course_enrollment_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EnrollmentEntity {
    @Id
    private String enrollId;
    @ManyToOne
    @JoinColumn(name="stdId")
    private StudentEntities studentId;
    @ManyToOne
    @JoinColumn(name="courseId")
    private CourseEntity courseId;
    private String getEnrolledDate;
    private String marks;
    private String grade;
}
