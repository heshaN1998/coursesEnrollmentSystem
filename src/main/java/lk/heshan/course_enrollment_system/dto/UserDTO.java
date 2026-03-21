package lk.heshan.course_enrollment_system.dto;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDTO implements Serializable {
    private String userId;
    private  String firstName;
    private String lastNMame;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private  String password;
    private Role role;
}
