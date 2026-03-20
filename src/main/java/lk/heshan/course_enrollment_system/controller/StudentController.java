package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {
//save Student

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<UserDTO>saveStudent(@RequestBody UserDTO userDTO){
    return new ResponseEntity<>(userDTO, HttpStatus.CREATED);

}

@GetMapping(value = "{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
public  ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentId){
    System.out.println("student id is"+studentId);
    var userDTO = new UserDTO(
            userId: "U001",
            firstName: "Heshan",
            lastName:"Perera",
            addressLine1: "No 123",
            addressLine2 :"Main Street",
            addressLine3 :"Colombo 05",
            city :"Colombo",
            password: "1234",
            Role.STUDENT
    );
    if(studentId.equals(userDTO.getUserId())){
        return new ResponseEntity<>(userDTO,OK);
    }

}


}
