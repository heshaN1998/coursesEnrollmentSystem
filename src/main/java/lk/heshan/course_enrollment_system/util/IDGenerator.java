package lk.heshan.course_enrollment_system.util;

import java.util.UUID;

public class IDGenerator {
    public static String studentIdGen(){
        return "STU-"+ UUID.randomUUID();
    }

    public static String lecturertIdGen(){
        return "LEC-"+ UUID.randomUUID();
    }

    public static String adminIdGen(){
        return "ADM-"+ UUID.randomUUID();
    }

    public static String courseIdGen(){
        return "CRS-"+ UUID.randomUUID();
    }
}