package lk.heshan.course_enrollment_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.heshan.course_enrollment_system.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StudentEntities {
        @Id
        private String stdId;
        private  String firstName;
        private String lastNMame;
        private String email;
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String city;
        private  String password;
        @Enumerated(EnumType.STRING)
        private Role role;
}
