package lk.heshan.course_enrollment_system.dao;

import lk.heshan.course_enrollment_system.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<CourseEntity,String> {

}
