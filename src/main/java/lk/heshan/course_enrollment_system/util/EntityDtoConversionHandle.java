package lk.heshan.course_enrollment_system.util;


import lk.heshan.course_enrollment_system.dao.LecturerDao;
import lk.heshan.course_enrollment_system.dto.CourseDTO;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.entities.AdminEntities;
import lk.heshan.course_enrollment_system.entities.CourseEntity;
import lk.heshan.course_enrollment_system.entities.LecturerEntities;
import lk.heshan.course_enrollment_system.entities.StudentEntities;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EntityDtoConversionHandle {
    private final ModelMapper modelMapper;
    private final LecturerDao lecturerDao;

    //Users
    public UserDTO toStudentDTO(StudentEntities student) {
        return modelMapper.map(student, UserDTO.class);
    }

    public StudentEntities toStudentEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, StudentEntities.class);
    }

    public List<UserDTO> getStudentList(List<StudentEntities> studentEntityList) {
        return modelMapper.map(studentEntityList, new TypeToken<List<UserDTO>>() {
        }.getType());
    }


    public UserDTO toLecturerDTO(LecturerEntities lecturer) {
        return modelMapper.map(lecturer, UserDTO.class);
    }

    public LecturerEntities toLecturerEntity(UserDTO lecturerDTO) {
        return modelMapper.map(lecturerDTO, LecturerEntities.class);
    }

    public List<UserDTO> getLecturerList(List<LecturerEntities> lecturerEntitiesList) {
        return modelMapper.map(lecturerEntitiesList, new TypeToken<List<UserDTO>>() {
        }.getType());
    }


    public UserDTO toAdminDTO(AdminEntities admin) {
        return modelMapper.map(admin, UserDTO.class);
    }

    public AdminEntities toAdminEntity(UserDTO adminDTO) {
        return modelMapper.map(adminDTO, AdminEntities.class);
    }

    public List<UserDTO> getAdminList(List<AdminEntities> adminEntityList) {
        return modelMapper.map(adminEntityList, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    //Course
    public CourseDTO toCourseDTO(CourseEntity courseEntity) {

        var courseDTO = new CourseDTO();
        courseDTO.setCourseId(courseEntity.getCourseId());
        courseDTO.setCourseCode(courseEntity.getCourseCode());
        courseDTO.setCourseName(courseEntity.getCourseName());
        courseDTO.setDescription(courseEntity.getDescription());
        courseDTO.setDayOfWeek(courseEntity.getDayOfWeek());
        courseDTO.setCredit(courseEntity.getCredit());
        courseDTO.setStartTime(courseEntity.getStartTime());
        courseDTO.setEndTime(courseEntity.getEndTime());
        if(courseEntity.getInstructorId() != null){
            courseDTO.setInstructorId(courseEntity.getInstructorId().getId());
        }
        return courseDTO;

    }
    public CourseEntity toCourseEntity(CourseDTO courseDTO) {
        var courseEntity = new CourseEntity();
        courseEntity.setCourseCode(courseDTO.getCourseId());
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setDescription(courseDTO.getDescription());
        courseDTO.setCourseCode(courseEntity.getCourseCode());
        courseEntity.setCredit(courseDTO.getCredit());
        courseEntity.setDayOfWeek(courseDTO.getDayOfWeek());
        courseEntity.setStartTime(courseDTO.getStartTime());
        courseEntity.setEndTime(courseDTO.getEndTime());
        if (courseEntity.getInstructorId() != null) {
            LecturerEntities lecturer = lecturerDao.findById(courseDTO.getInstructorId()).orElseThrow(() -> new RuntimeException("Lecturer not found"));

        }
        return courseEntity;
    }
    public List<CourseDTO> toCourseDTOList(List<CourseEntity> courseEntities){
        return courseEntities.stream().toList().stream().map(this::toCourseDTO).toList();
    }
    public List<CourseEntity> toCourseEntityList(List<CourseDTO>courseDTOS){
        return courseDTOS.stream().map(this::toCourseEntity).toList();
    }

}
