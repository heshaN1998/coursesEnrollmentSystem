package lk.heshan.course_enrollment_system.impl;

import lk.heshan.course_enrollment_system.dto.CourseDTO;
import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.CourseServics;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseServiceIMPL implements CourseServics {
    @Override
    public void saveCourse(CourseDTO course) {

    }

    @Override
    public CourseDTO getSelectedCourse(String courseId) throws Exception {
        CourseDTO selectedCourse= new CourseDTO(
                "CSC001",
                "CS101",
                "Introduction to Programming",
                "Basic concepts of programming using Java",
                3,
                "Monday",
                LocalTime.of(9, 0),
                LocalTime.of(11, 0),
                "LEC001"
        );
        if (courseId.equals(selectedCourse.getCourseId())) {
            return selectedCourse;
        }
        throw new Exception("Course not found");
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return Arrays.asList(
         new CourseDTO(
                "C001",
                "CS101",
                "Introduction to Programming",
                "Basic concepts of programming using Java",
                3,
                "Monday",
                LocalTime.of(9, 0),
                LocalTime.of(11, 0),
                "I001"
        ),

         new CourseDTO(
                "C002",
                "CS202",
                "Data Structures",
                "Study of data structures like lists, stacks, queues",
                4,
                "Wednesday",
                LocalTime.of(13, 0),
                LocalTime.of(15, 0),
                "I002"
        ),

         new CourseDTO(
                "C003",
                "CS303",
                "Database Systems",
                "Introduction to relational databases and SQL",
                3,
                "Friday",
                LocalTime.of(10, 30),
                LocalTime.of(12, 30),
                "I003"));
    };

    @Override
    public void updateCourse(String courseId, CourseDTO toBeUpdatedCourse) {

    }

    @Override
    public void deleteCourse(String courseId) {

    }
}
