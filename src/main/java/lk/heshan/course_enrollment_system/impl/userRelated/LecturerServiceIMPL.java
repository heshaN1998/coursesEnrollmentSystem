package lk.heshan.course_enrollment_system.impl.userRelated;

import jakarta.transaction.Transactional;
import lk.heshan.course_enrollment_system.dao.LecturerDao;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.entities.LecturerEntities;
import lk.heshan.course_enrollment_system.entities.StudentEntities;
import lk.heshan.course_enrollment_system.service.GenericUserService;
import lk.heshan.course_enrollment_system.util.EntityDtoConversionHandle;
import lk.heshan.course_enrollment_system.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LecturerServiceIMPL implements GenericUserService<UserDTO> {
    private final LecturerDao lecturerDao;
    private final EntityDtoConversionHandle conversionHandle;
    @Override
    public void saveUser(UserDTO LEC) {

    var lecturerEntity =conversionHandle.toLecturerEntity(LEC);
    lecturerEntity.setId(IDGenerator.lecturertIdGen());
    lecturerDao.save(lecturerEntity);
    }

    @Override
    public UserDTO getSelectedUser(String lectureId) throws Exception {
        Optional<LecturerEntities> foundLecturer = lecturerDao.findById(lectureId);
        if (!foundLecturer.isPresent()) {
            throw new Exception("Lecturer is not found");
        }
        return conversionHandle.toLecturerDTO(lecturerDao.getReferenceById(lectureId));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return conversionHandle.getLecturerList(lecturerDao.findAll());
    }

    @Override
    public void updateUser(String lectId, UserDTO toBeUpdatedLecturer) throws Exception{
        Optional<LecturerEntities> foundLecturer = lecturerDao.findById(lectId);
        if (!foundLecturer.isPresent()) {
            throw new Exception("Lecturer is not found");
        }
        foundLecturer.get().setFirstName(toBeUpdatedLecturer.getFirstName());
        foundLecturer.get().setLastNMame(toBeUpdatedLecturer.getLastNMame());
        foundLecturer.get().setAddressLine1(toBeUpdatedLecturer.getAddressLine1());
        foundLecturer.get().setAddressLine2(toBeUpdatedLecturer.getAddressLine2());
        foundLecturer.get().setAddressLine3(toBeUpdatedLecturer.getAddressLine3());
        foundLecturer.get().setCity(toBeUpdatedLecturer.getCity());
        foundLecturer.get().setPassword(toBeUpdatedLecturer.getPassword());

    }

    @Override
    public void deleteUser(String lectureId) throws Exception {
        Optional<LecturerEntities> foundLecturer = lecturerDao.findById(lectureId);
        if (!foundLecturer.isPresent()) {
            throw new Exception("Lecturer is not found");
        }
        lecturerDao.deleteById(lectureId);

    }
}
