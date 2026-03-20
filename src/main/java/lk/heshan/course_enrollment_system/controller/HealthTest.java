package lk.heshan.course_enrollment_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/healthtest")
public class HealthTest {
    @GetMapping
    private String StudentDataTest(){
        return "student controller is running";
    }
}
