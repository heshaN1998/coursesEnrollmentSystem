package lk.heshan.course_enrollment_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentDTO implements Serializable {
    private String enrollId;
    private String studentId;
    private String courseId;
    private String getEnrolledDate;
    private String marks;
    private String grade;
}

