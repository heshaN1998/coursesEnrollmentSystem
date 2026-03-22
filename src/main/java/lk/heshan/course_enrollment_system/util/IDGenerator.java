package lk.heshan.course_enrollment_system.util;

import java.util.UUID;

public class IDGenerator {
    public static String studentIdGen(){
        return "STU-"+ UUID.randomUUID();
    }
}