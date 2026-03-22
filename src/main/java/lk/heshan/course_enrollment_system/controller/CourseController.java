package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.CourseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(CourseDTO courseDTO){
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
}
    @GetMapping("{courseId}")
    public  ResponseEntity<CourseDTO> getSelectedCourse(@PathVariable String courseId){
        return null;
    }
    @GetMapping
    public ResponseEntity<CourseDTO>getAllCouses(){
        return null;
    }
    @DeleteMapping("{courseId}")
    public void deleteCourse(@PathVariable String courseId){

    }
    @PatchMapping("{courseId}")
    public  void updateCourse(@PathVariable String courseId,CourseDTO courseDto){

    }


}
