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
    public ResponseEntity<Void> saveCourse( @RequestBody CourseDTO courseDTO){
        courseService.saveCourse(courseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

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
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseId){
        try {
            courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    @PatchMapping("{courseId}")
    public  ResponseEntity<Void> updateCourse(@PathVariable String courseId,@RequestBody CourseDTO courseDto){

            try {
                courseService.updateCourse(courseId,courseDto);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }


}
