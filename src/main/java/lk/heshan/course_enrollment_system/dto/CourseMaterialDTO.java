package lk.heshan.course_enrollment_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterialDTO implements Serializable {
    private String materialId;
    private  String materialType;
    private String fileName;
    private String material;
    private String courseId;
    private String uploadAt;

}
