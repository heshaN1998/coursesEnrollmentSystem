package lk.heshan.course_enrollment_system.impl;

import jakarta.transaction.Transactional;
import lk.heshan.course_enrollment_system.dao.CourseDao;
import lk.heshan.course_enrollment_system.dto.CourseDTO;
import lk.heshan.course_enrollment_system.dto.Role;
import lk.heshan.course_enrollment_system.dto.UserDTO;
import lk.heshan.course_enrollment_system.entities.CourseEntity;
import lk.heshan.course_enrollment_system.entities.StudentEntities;
import lk.heshan.course_enrollment_system.service.CourseServics;
import lk.heshan.course_enrollment_system.util.EntityDtoConversionHandle;
import lk.heshan.course_enrollment_system.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceIMPL implements CourseServics {
    private final CourseDao courseDao;
    private final EntityDtoConversionHandle entityDtoConversionHandle;
    @Override
    public void saveCourse(CourseDTO course) {
        var courseEntity = entityDtoConversionHandle.toCourseEntity(course);
        courseEntity.setCourseId(IDGenerator.courseIdGen());
        courseDao.save(courseEntity);

    }

    @Override
    public CourseDTO getSelectedCourse(String courseId) throws Exception {
        Optional<CourseEntity> foundCourse = courseDao.findById(courseId);
        if (!foundCourse.isPresent()) {
            throw new Exception("Course is not found");
        }
        return entityDtoConversionHandle.toCourseDTO(courseDao.getReferenceById(courseId));
    }
    @Override
    public List<CourseDTO> getAllCourses() {
          return entityDtoConversionHandle.toCourseDTOList(courseDao.findAll());
    }

    @Override
    public void updateCourse(String courseId, CourseDTO toBeUpdatedCourse) throws Exception {
        Optional<CourseEntity> foundCourse = courseDao.findById(courseId);
        if (!foundCourse.isPresent()) {
            throw new Exception("Course is not found");
        }
        foundCourse.get().setCourseName(toBeUpdatedCourse.getCourseName());
        foundCourse.get().setCourseCode(toBeUpdatedCourse.getCourseCode());
        foundCourse.get().setDescription(toBeUpdatedCourse.getDescription());
        foundCourse.get().setCredit(toBeUpdatedCourse.getCredit());
        foundCourse.get().setDayOfWeek(toBeUpdatedCourse.getDayOfWeek());
        foundCourse.get().setStartTime(toBeUpdatedCourse.getStartTime());
        foundCourse.get().setEndTime(toBeUpdatedCourse.getEndTime());
        foundCourse.get().setCourseId(toBeUpdatedCourse.getCourseId());

    }

    @Override
    public void deleteCourse(String courseId) throws Exception {
        Optional<CourseEntity> foundCourse = courseDao.findById(courseId);
        if (!foundCourse.isPresent()) {
            throw new Exception("Course is not found");
        }
        courseDao.deleteById(courseId);
    }
}
