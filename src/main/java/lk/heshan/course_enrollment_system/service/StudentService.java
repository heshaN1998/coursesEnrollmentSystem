package lk.heshan.course_enrollment_system.service;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.impl.StudentServiceIMPL;

import java.util.List;

public interface StudentService {
void saveStudent(UserDTO student);
UserDTO getSelectedStudent(String studentId) throws Exception ;
List<UserDTO> getAllStudents();
void updateStudent(String studentId,UserDTO toBeUpdatedStudent);
void deleteStudent(String studentId);
}
