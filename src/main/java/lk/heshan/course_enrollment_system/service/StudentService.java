package lk.heshan.course_enrollment_system.service;

import lk.heshan.course_enrollment_system.dto.UserDTO;


import java.util.List;

public interface StudentService {
void saveStudent(UserDTO student);
UserDTO getSelectedStudent(String studentId);
List<UserDTO> getAllStudents();
void updateStudent(String studentId,UserDTO toBeUpdatedStudent);
void deleteStudent(String StudentId);
}
