package lk.heshan.course_enrollment_system.service.impl;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    @Override
    public void saveStudent(UserDTO student) {

    }

    @Override
    public UserDTO getSelectedStudent(String studentId) {
        return null;
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
