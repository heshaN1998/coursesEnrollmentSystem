package lk.heshan.course_enrollment_system.impl.userRelated;
import jakarta.transaction.Transactional;
import lk.heshan.course_enrollment_system.dao.StudentDao;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.entities.StudentEntities;
import lk.heshan.course_enrollment_system.service.StudentService;
import lk.heshan.course_enrollment_system.util.EntityDtoConversionHandle;
import lk.heshan.course_enrollment_system.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceIMPL implements StudentService {
private  final StudentDao studentDao;
private final EntityDtoConversionHandle conversionHandle;

    @Override
    public void saveStudent(UserDTO student) {
       var studentEntities=conversionHandle.toStudentEntity(student);
       studentEntities.setId(IDGenerator.studentIdGen());
       studentDao.save(studentEntities);
    }

    @Override
    public UserDTO getSelectedStudent(String studentId) throws Exception {
        Optional<StudentEntities> foundStudent =studentDao.findById(studentId);
        if(!foundStudent.isPresent()) {
            throw new Exception("Student is not found");
        }
            StudentEntities selectedStudent = studentDao.getReferenceById(studentId);
            return conversionHandle.toStudentDTO(selectedStudent);

    }
    @Override
    public List<UserDTO> getAllStudents() {
     return conversionHandle.getStudentList(studentDao.findAll());

    }


    @Override
    public void updateStudent(String studentId, UserDTO toBeUpdatedStudent) throws Exception {
        Optional<StudentEntities> foundStudent = studentDao.findById(studentId);
        if (!foundStudent.isPresent()) {
            throw new Exception("Student is not found");
        }
        foundStudent.get().setCity(toBeUpdatedStudent.getCity());
        foundStudent.get().setFirstName(toBeUpdatedStudent.getFirstName());
        foundStudent.get().setLastNMame(toBeUpdatedStudent.getLastNMame());
        foundStudent.get().setAddressLine1(toBeUpdatedStudent.getAddressLine1());
        foundStudent.get().setAddressLine2(toBeUpdatedStudent.getAddressLine2());
        foundStudent.get().setAddressLine3(toBeUpdatedStudent.getAddressLine3());
        foundStudent.get().setPassword(toBeUpdatedStudent.getPassword());

    }

    @Override
    public void deleteStudent(String studentId) {
        Optional<StudentEntities> foundStudent =studentDao.findById(studentId);
        if (!foundStudent.isPresent()){
             new Exception("Student not found");
        }
        studentDao.deleteById(studentId);


    }
}
