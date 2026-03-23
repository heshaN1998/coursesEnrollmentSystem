package lk.heshan.course_enrollment_system.service;

import lk.heshan.course_enrollment_system.dto.UserDTO;

import java.util.List;

public interface GenericUserService<T> {
    void saveUser(T LEC);
    T getSelectedUser(String adminId) throws Exception ;
    List<T> getAllUsers();
    void updateUser(String adminId,T toBeUpdatedAdmin) throws Exception;
    void deleteUser(String adminId) throws Exception;

}
