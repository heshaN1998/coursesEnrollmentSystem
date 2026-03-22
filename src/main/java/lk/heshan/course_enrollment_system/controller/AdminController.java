package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.AdminService;
import lk.heshan.course_enrollment_system.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/admin")

public class AdminController {
    @Autowired
    private AdminService adminService;
    //save Student

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveAdmin(@RequestBody UserDTO admin) {
        return new ResponseEntity<>(admin, HttpStatus.CREATED);

    }
    @GetMapping(value = "{adminId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedAdmin(@PathVariable String adminId){

        try {
            return new ResponseEntity<>(adminService.getSelectedAdmin(adminId),HttpStatus.OK);
            }catch ( Exception ex){
        ex.printStackTrace();
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<UserDTO>> getAllAdmin(){

        return new ResponseEntity<>(adminService.getAllAdmins(),HttpStatus.OK);
    }
    @PatchMapping
    public void updateAdmin(@RequestParam("lecId") String admintId,@RequestParam String admCity,@RequestBody UserDTO toBeUpdatedAdminDto){
        System.out.println("student id:"+admintId);
        System.out.println("student city:"+admCity);
        System.out.println("to be updated details:"+toBeUpdatedAdminDto);
    }
    @DeleteMapping
    public  void deleteLecturer(@RequestParam("X-adminId") String adminId){
        System.out.println("to be deleted Id"+adminId);
    }
}
