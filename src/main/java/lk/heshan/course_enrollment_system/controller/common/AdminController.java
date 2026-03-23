package lk.heshan.course_enrollment_system.controller.common;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.impl.userRelated.AdminServiceIMPL;
import lk.heshan.course_enrollment_system.service.GenericUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/admin")

public class AdminController extends GenericController<UserDTO> {
   // public AdminController(GenericUserService<UserDTO> userService){
   @Autowired
    public AdminController(AdminServiceIMPL adminServiceIMPL){
        super(adminServiceIMPL);
    }

}
