package lk.heshan.course_enrollment_system.controller.common;

import lk.heshan.course_enrollment_system.dto.UserDTO;

import lk.heshan.course_enrollment_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/student")

public class StudentController {
    @Autowired
    private StudentService studentService;
    //save Student

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStudent(@RequestBody UserDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return new ResponseEntity<>( HttpStatus.CREATED);

    }
    @GetMapping(value = "{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentId){

        try {
            var selectedStudent=new UserDTO();
            selectedStudent = studentService.getSelectedStudent(studentId);
            return new ResponseEntity<>(selectedStudent,HttpStatus.OK);
            }catch ( Exception ex){
        ex.printStackTrace();
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<UserDTO>> getAllStudent(){

        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Void> updateStudent(@RequestParam("id") String studentId,@RequestParam String stuCity,@RequestBody UserDTO toBeUpdatedStudentDto){
    try {
        studentService.updateStudent(studentId,toBeUpdatedStudentDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }
    @DeleteMapping
    public  ResponseEntity<Void> deleteStudent(@PathVariable String studentId){
        try{
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
