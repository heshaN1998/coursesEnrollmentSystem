package lk.heshan.course_enrollment_system.impl;
import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.StudentService;

import java.util.List;

public class StudentServiceIMPL implements StudentService {

    @Override
    public void saveStudent(UserDTO student) {

    }

    @Override
    public UserDTO getSelectedStudent(String studentId) {
        return new UserDTO(
                "U001",
                "Heshan",
                "Perera",
                "No 123",
                "Main Street",
                "Colombo 05",
                "Colombo",
                "1234",
                Role.STUDENT);

    }

    @Override
    public List<UserDTO> getAllStudents() {
        return List.of();
    }

    @Override
    public void updateStudent(String studentId, UserDTO toBeUpdatedStudent) {

    }

    @Override
    public void deleteStudent(String StudentId) {

    }
}
