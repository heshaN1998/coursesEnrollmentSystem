package lk.heshan.course_enrollment_system.util;


import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.entities.AdminEntities;
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

        public UserDTO toStudentDTO(StudentEntities student){
            return modelMapper.map(student, UserDTO.class);
        }
        public StudentEntities toStudentEntity(UserDTO userDTO){
            return modelMapper.map(userDTO, StudentEntities.class);
        }
        public List<UserDTO> getStudentList(List<StudentEntities> studentEntityList){
            return modelMapper.map(studentEntityList,new TypeToken<List<UserDTO>>(){}.getType());
        }


    public UserDTO toLecturerDTO(LecturerEntities lecturer){
        return modelMapper.map(lecturer, UserDTO.class);
    }
    public LecturerEntities toLecturerEntity(UserDTO lecturerDTO){
        return modelMapper.map(lecturerDTO, LecturerEntities.class);
    }
    public List<UserDTO> getLecturerList(List<LecturerEntities> lecturerEntitiesList){
        return modelMapper.map(lecturerEntitiesList,new TypeToken<List<UserDTO>>(){}.getType());
    }


    public UserDTO toAdminDTO(AdminEntities admin){
        return modelMapper.map(admin, UserDTO.class);
    }
    public AdminEntities toAdminEntity(UserDTO adminDTO){
        return modelMapper.map(adminDTO, AdminEntities.class);
    }
    public List<UserDTO> getAdminList(List<AdminEntities> adminEntityList){
        return modelMapper.map(adminEntityList,new TypeToken<List<UserDTO>>(){}.getType());
    }
}
