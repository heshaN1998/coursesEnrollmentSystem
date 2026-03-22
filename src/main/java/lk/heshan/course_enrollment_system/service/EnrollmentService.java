package lk.heshan.course_enrollment_system.service;

import lk.heshan.course_enrollment_system.dto.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {
void saveEnrollment(EnrollmentDTO enrollment);
EnrollmentDTO getSelectedEnrollment(String enrollmentId) throws Exception ;
List<EnrollmentDTO> getAllEnrollment();
void updateEnrollment(String enrollmentId,EnrollmentDTO toBeUpdatedEnrollment);
void deleteEnrollment(String enrollmentId);
}
