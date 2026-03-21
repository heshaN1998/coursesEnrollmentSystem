package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.impl.LecturerServiceIMPL;
import lk.heshan.course_enrollment_system.service.LecturerService;
import lk.heshan.course_enrollment_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/lecturer")

public class LecturerController {
    @Autowired
    private LecturerService lecturerService;
    //save Student

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveLecturer(@RequestBody UserDTO lecturer) {
        return new ResponseEntity<>(lecturer, HttpStatus.CREATED);

    }
    @GetMapping(value = "{lecturerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedLecturer(@PathVariable String lecturerId){

        try {
            return new ResponseEntity<>(lecturerService.getSelectedLecturer(lecturerId),HttpStatus.OK);
            }catch ( Exception ex){
        ex.printStackTrace();
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<UserDTO>> getAllLecturers(){

        return new ResponseEntity<>(lecturerService.getAllLecturers(),HttpStatus.OK);
    }
    @PatchMapping
    public void updateLecturer(@RequestParam("lecId") String lecturertId,@RequestParam String lecCity,@RequestBody UserDTO toBeUpdatedStudentDto){
        System.out.println("student id:"+lecturertId);
        System.out.println("student city:"+lecCity);
        System.out.println("to be updated details:"+toBeUpdatedStudentDto);
    }
    @DeleteMapping
    public  void deleteLecturer(@RequestParam("X-lecturerId") String lecturereId){
        System.out.println("to be deleted Id"+lecturereId);
    }
}
