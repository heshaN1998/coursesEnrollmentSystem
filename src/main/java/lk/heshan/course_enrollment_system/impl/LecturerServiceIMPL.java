package lk.heshan.course_enrollment_system.impl;

import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.LecturerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class LecturerServiceIMPL implements LecturerService {
    @Override
    public void saveLecturer(UserDTO lecturer) {

    }

    @Override
    public UserDTO getSelectedLecturer(String lecturerId) throws Exception {
        UserDTO selectedLecturer= new UserDTO(
                "LEC001",
                "Heshan",
                "Perera",
                "No 123",
                "Main Street",
                "Colombo 05",
                "Colombo",
                "1234",
                Role.LECTURER);
        if (lecturerId.equals(selectedLecturer.getUserId())){

            return selectedLecturer;
        }
        throw new Exception("Lecturer not found");
    }

    @Override
    public List<UserDTO> getAllLecturers() {
        return Arrays.asList(
                new UserDTO(
                        "LEC002",
                        "Nimal",
                        "Silva",
                        "No 45",
                        "Lake Road",
                        "Kandy 02",
                        "Kandy",
                        "abcd",
                        Role.LECTURER),
                new UserDTO(
                        "LEC003",
                        "Kamal",
                        "Fernando",
                        "No 78",
                        "Temple Road",
                        "Galle 03",
                        "Galle",
                        "pass123",
                        Role.LECTURER),
                new UserDTO(
                        "LEC004",
                        "Saman",
                        "Kumara",
                        "No 10",
                        "Station Road",
                        "Kurunegala",
                        "Kurunegala",
                        "xyz789",
                        Role.LECTURER)

        );
    }


    @Override
    public void updateLecturer(String lecturerId, UserDTO toBeUpdatedLecturer) {

    }

    @Override
    public void deleteLecturer(String lecturerId) {

    }
}
