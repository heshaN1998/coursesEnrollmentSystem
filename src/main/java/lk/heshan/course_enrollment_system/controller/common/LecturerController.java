package lk.heshan.course_enrollment_system.controller.common;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.impl.userRelated.LecturerServiceIMPL;
import lk.heshan.course_enrollment_system.service.GenericUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/lecturer")

public class LecturerController extends GenericController<UserDTO> {

    // public LecturerController(GenericUserService<UserDTO>userService){
   @Autowired
    public LecturerController(LecturerServiceIMPL lecturerServiceIMPL){
    super(lecturerServiceIMPL);
    }


}
