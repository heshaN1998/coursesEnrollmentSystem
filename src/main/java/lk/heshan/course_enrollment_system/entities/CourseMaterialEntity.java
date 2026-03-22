package lk.heshan.course_enrollment_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CourseMaterialEntity {
    @Id
    private String materialId;
    private  String materialType;
    private String fileName;
    private String material;
    @ManyToOne
    @JoinColumn(name="courseId")
    private CourseEntity courseId;
    private LocalDateTime uploadAt;

}
