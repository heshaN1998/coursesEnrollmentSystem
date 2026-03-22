package lk.heshan.course_enrollment_system.impl;

import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminServiceIMPL implements AdminService {
    @Override
    public void addAdmin(UserDTO admin) {

    }

    @Override
    public UserDTO getSelectedAdmin(String adminId) throws Exception {

        UserDTO selectedAdmin= new UserDTO(
                "ADM001",
                "Heshan",
                "Perera",
                "No 123",
                "Main Street",
                "Colombo 05",
                "Colombo",
                "1234",
                Role.ADMIN);
        if (adminId.equals(selectedAdmin.getUserId())){

            return selectedAdmin;
        }
        throw new Exception("Admin not found");
    }

    @Override
    public List<UserDTO> getAllAdmins() {
        return Arrays.asList(
                new UserDTO(
                        "ADM002",
                        "Nimal",
                        "Silva",
                        "No 45",
                        "Lake Road",
                        "Kandy 02",
                        "Kandy",
                        "abcd",
                        Role.ADMIN),
                new UserDTO(
                        "ADM003",
                        "Kamal",
                        "Fernando",
                        "No 78",
                        "Temple Road",
                        "Galle 03",
                        "Galle",
                        "pass123",
                        Role.ADMIN),
                new UserDTO(
                        "ADM004",
                        "Saman",
                        "Kumara",
                        "No 10",
                        "Station Road",
                        "Kurunegala",
                        "Kurunegala",
                        "xyz789",
                        Role.ADMIN)

        );    }

    @Override
    public void updateAdmin(String adminId, UserDTO toBeUpdatedAdmin) {

    }

    @Override
    public void deleteAdmin(String adminId) {

    }
}
