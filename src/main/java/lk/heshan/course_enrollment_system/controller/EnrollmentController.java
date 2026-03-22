package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.EnrollmentDTO;
import lk.heshan.course_enrollment_system.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/enroll")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    @PostMapping
    public ResponseEntity<EnrollmentDTO> saveEnrollment(@RequestBody EnrollmentDTO enrolment){
        return new ResponseEntity<>(enrolment,HttpStatus.CREATED);

    }
    @GetMapping("{enrollmentId}")
    public ResponseEntity<EnrollmentDTO> getSelectedEnrollment(@PathVariable String enrollmentId){
        try {
        return new ResponseEntity<>(enrollmentService.getSelectedEnrollment(enrollmentId),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}

    }
    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollment(){
        return new ResponseEntity<>(enrollmentService.getAllEnrollment(),HttpStatus.OK);
    }
    @DeleteMapping("{enrollmentId}")
    public void deleteEnrollment(@PathVariable String enrollmentId){

    }
    @PatchMapping("{enrollmentId}")
    public void updateEnrollment(@PathVariable String enrollmentId,EnrollmentDTO enrollment){

    }
}
