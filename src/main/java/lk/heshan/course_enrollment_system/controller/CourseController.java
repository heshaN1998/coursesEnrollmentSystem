package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.CourseDTO;
import lk.heshan.course_enrollment_system.service.CourseServics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {
 private final CourseServics courseService;
    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse( @RequestBody CourseDTO courseDTO){
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
}
    @GetMapping("{courseId}")
    public  ResponseEntity<CourseDTO> getSelectedCourse(@PathVariable String courseId) {
        try {
          return new ResponseEntity<>(courseService.getSelectedCourse(courseId),HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<CourseDTO>>getAllCouses(){
        return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
    }
    @DeleteMapping("{courseId}")
    public void deleteCourse(@PathVariable String courseId){

    }
    @PatchMapping("{courseId}")
    public  void updateCourse(@PathVariable String courseId,CourseDTO courseDto){

    }


}
