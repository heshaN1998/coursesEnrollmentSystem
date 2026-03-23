package lk.heshan.course_enrollment_system.service;

import lk.heshan.course_enrollment_system.dto.CourseDTO;
import lk.heshan.course_enrollment_system.dto.UserDTO;

import java.util.List;

public interface CourseServics {
void saveCourse(CourseDTO course);
CourseDTO getSelectedCourse(String courseId) throws Exception ;
List<CourseDTO> getAllCourses();
void updateCourse(String courseId,CourseDTO toBeUpdatedCourse) throws Exception;
void deleteCourse(String courseId) throws Exception;
}
