package lk.heshan.course_enrollment_system.impl;

import lk.heshan.course_enrollment_system.dto.EnrollmentDTO;
import lk.heshan.course_enrollment_system.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class EnrollmentServiceIMPL implements EnrollmentService {
    @Override
    public void saveEnrollment(EnrollmentDTO enrollment) {

    }

    @Override
    public EnrollmentDTO getSelectedEnrollment(String enrollmentId) throws Exception {
        var selectedEnrollment  = new EnrollmentDTO(
                "E003",
                "S003",
                "C003",
                "2025-01-20",
                "92",
                "A+"
        );
        if(enrollmentId.equals(selectedEnrollment.getEnrollId())){
            return selectedEnrollment;
        }
        throw new Exception("Enrollment Not Found");
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollment() {
        return Arrays.asList(
                new EnrollmentDTO(
                "E001",
                "S001",
                "C001",
                "2025-01-15",
                "85",
                "A"
        ),

        new EnrollmentDTO(
                "E002",
                "S002",
                "C002",
                "2025-01-18",
                "78",
                "B+"
        ),

        new EnrollmentDTO(
                "E003",
                "S003",
                "C003",
                "2025-01-20",
                "92",
                "A+"
        ));

    }

    @Override
    public void updateEnrollment(String enrollmentId, EnrollmentDTO toBeUpdatedEnrollment) {

    }

    @Override
    public void deleteEnrollment(String enrollmentId) {

    }
}
