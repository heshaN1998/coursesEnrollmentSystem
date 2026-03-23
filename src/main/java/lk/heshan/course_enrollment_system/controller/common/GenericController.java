package lk.heshan.course_enrollment_system.controller.common;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.GenericUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class GenericController<T> {
    private final GenericUserService<T> userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody T user) {
        userService.saveUser(user);
        //studentService.saveStudent(studentDTO);
        return new ResponseEntity<>( HttpStatus.CREATED);

    }
    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getSelectedUser(@PathVariable String id){

        try {
            //var selectedStudent=new UserDTO();
            //selectedStudent = studentService.getSelectedUsers(studentId);
            return new ResponseEntity<T>(userService.getSelectedUser(id),HttpStatus.OK);
        }catch ( Exception ex){
            ex.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<T>> getAllUsers(){

        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Void> updateUser(@RequestParam("id") String id,@RequestParam String stuCity,@RequestBody T toBeUpdatedUserDetails) {
        try {
            userService.updateUser(id,toBeUpdatedUserDetails);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping
    public  ResponseEntity<Void> deleteStudent(@PathVariable String id){
        try{
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
