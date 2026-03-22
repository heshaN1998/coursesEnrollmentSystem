package lk.heshan.course_enrollment_system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="course")
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
