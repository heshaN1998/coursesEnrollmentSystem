package lk.heshan.course_enrollment_system.service;

import lk.heshan.course_enrollment_system.dto.UserDTO;

import java.util.List;

public interface LecturerService {
void saveLecturer(UserDTO lecturer);
UserDTO getSelectedLecturer(String lecturerId) throws Exception ;
List<UserDTO> getAllLecturers();
void updateLecturer(String lecturerId,UserDTO toBeUpdatedLecturer);
void deleteLecturer(String lecturerId);
}
