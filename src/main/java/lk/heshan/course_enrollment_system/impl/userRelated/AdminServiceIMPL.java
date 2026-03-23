package lk.heshan.course_enrollment_system.impl.userRelated;

import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.service.GenericUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceIMPL implements GenericUserService <UserDTO>{

    @Override
    public void saveUser(UserDTO LEC) {

    }

    @Override
    public UserDTO getSelectedUser(String adminId) throws Exception {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public void updateUser(String adminId, UserDTO toBeUpdatedAdmin) {

    }

    @Override
    public void deleteUser(String adminId) {

    }
}
