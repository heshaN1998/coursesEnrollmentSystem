package lk.heshan.course_enrollment_system.service;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AdminService {
void addAdmin(UserDTO admin);
UserDTO getSelectedAdmin(String adminId) throws Exception ;
List<UserDTO> getAllAdmins();
void updateAdmin(String adminId,UserDTO toBeUpdatedAdmin);
void deleteAdmin(String adminId);
}
