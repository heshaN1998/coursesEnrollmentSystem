package lk.heshan.course_enrollment_system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="course_material")
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
