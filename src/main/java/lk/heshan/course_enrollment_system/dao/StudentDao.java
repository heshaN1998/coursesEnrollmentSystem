package lk.heshan.course_enrollment_system.dao;

import lk.heshan.course_enrollment_system.entities.StudentEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<StudentEntities,String>{


}
