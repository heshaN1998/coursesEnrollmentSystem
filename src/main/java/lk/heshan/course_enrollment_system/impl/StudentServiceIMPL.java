package lk.heshan.course_enrollment_system.impl;
import lk.heshan.course_enrollment_system.dao.StudentDao;
import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceIMPL implements StudentService {
private  final StudentDao studentDao;
    @Override
    public void saveStudent(UserDTO student) {
        studentDao.save(student);
    }

    @Override
    public UserDTO getSelectedStudent(String studentId) throws Exception {
        UserDTO selectedStudent= new UserDTO(
                "U001",
                "Heshan",
                "Perera",
                "No 123",
                "Main Street",
                "Colombo 05",
                "Colombo",
                "1234",
                Role.STUDENT);
        if (studentId.equals(selectedStudent.getUserId())){

            return selectedStudent;
        }
        throw new Exception("Student not found");
    }

    @Override
    public List<UserDTO> getAllStudents() {
        List<UserDTO> studentList= Arrays.asList(
                new UserDTO(
                        "U002",
                        "Nimal",
                        "Silva",
                        "No 45",
                        "Lake Road",
                        "Kandy 02",
                        "Kandy",
                        "abcd",
                        Role.ADMIN),
                new UserDTO(
                        "U003",
                        "Kamal",
                        "Fernando",
                        "No 78",
                        "Temple Road",
                        "Galle 03",
                        "Galle",
                        "pass123",
                        Role.STUDENT),
                new UserDTO(
                        "U004",
                        "Saman",
                        "Kumara",
                        "No 10",
                        "Station Road",
                        "Kurunegala",
                        "Kurunegala",
                        "xyz789",
                        Role.STUDENT)

        );
        return studentList;
    }


    @Override
    public void updateStudent(String studentId, UserDTO toBeUpdatedStudent) {

    }

    @Override
    public void deleteStudent(String StudentId) {

    }
}
