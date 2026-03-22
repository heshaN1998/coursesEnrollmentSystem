package lk.heshan.course_enrollment_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class CourseEntity {
    @Id
    private String courseId;
    private String courseCode;
    private String courseName;
    private String description;
    private int credit;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name="lecId")
    private LecturerEntities instructorId;
}
