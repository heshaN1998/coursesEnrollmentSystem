package lk.heshan.course_enrollment_system.util;


import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.entities.StudentEntities;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EntityDtoConversionHandle {
        prste final ModelMapper modelMapper;

        public UserDTO toStudentDTO(StudentEntities student){
            return modelMapper.map(student, UserDTO.class);
        }
        public StudentEntities toStudentEntity(UserDTO userDTO){
            return modelMapper.map(userDTO, StudentEntities.class);
        }
        public List<UserDTO> getStudentList(List<StudentEntities> studentEntityList){
            return modelMapper.map(studentEntityList,new TypeToken<List<UserDTO>>(){}.getType());
        }
}
