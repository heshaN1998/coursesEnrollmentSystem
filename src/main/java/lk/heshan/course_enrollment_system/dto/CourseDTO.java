package lk.heshan.course_enrollment_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CourseDTO implements Serializable {
    private String courseId;
    private String courseCode;
    private String courseName;
    private String description;
    private int credit;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String instructorId;
}
