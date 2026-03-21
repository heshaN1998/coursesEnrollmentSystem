package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.impl.StudentServiceIMPL;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("api/v1/student")

public class StudentController {
    //save Student

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveStudent(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);

    }
    @GetMapping(value = "{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentId){
        System.out.println("Student ID"+studentId);
        var studentServiceIMPL=new StudentServiceIMPL();
        var selectedStudent = studentServiceIMPL.getSelectedStudent(studentId);

    if (studentId.equals(selectedStudent.getUserId())){
        studentServiceIMPL.getSelectedStudent(studentId);
        return new ResponseEntity<>(selectedStudent,HttpStatus.OK);

    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<UserDTO>> getAllStudent(){
        List<UserDTO> studentList= Arrays.asList(
                new UserDTO(
                        "U002",
                        "Nimal",
                        "Silva",
                        "No 45",
                        "Lake Road",
                        "Kandy 02",
                        "Kandy",
                        "abcd",
                        Role.ADMIN),
                new UserDTO(
                        "U003",
                        "Kamal",
                        "Fernando",
                        "No 78",
                        "Temple Road",
                        "Galle 03",
                        "Galle",
                        "pass123",
                        Role.STUDENT),
                new UserDTO(
                        "U004",
                        "Saman",
                        "Kumara",
                        "No 10",
                        "Station Road",
                        "Kurunegala",
                        "Kurunegala",
                        "xyz789",
                        Role.STUDENT)

        );
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
    @PatchMapping
    public void updateStudent(@RequestParam("stuId") String studentId,@RequestParam String stuCity,@RequestBody UserDTO toBeUpdatedStudentDto){
        System.out.println("student id:"+studentId);
        System.out.println("student city:"+stuCity);
        System.out.println("to be updated details:"+toBeUpdatedStudentDto);
    }
}
