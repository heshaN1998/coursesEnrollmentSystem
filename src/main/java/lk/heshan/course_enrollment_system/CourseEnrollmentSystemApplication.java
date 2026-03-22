package lk.heshan.course_enrollment_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CourseEnrollmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseEnrollmentSystemApplication.class, args);
	}

}
