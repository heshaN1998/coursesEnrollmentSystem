package lk.heshan.course_enrollment_system.controller;

import lk.heshan.course_enrollment_system.dto.CourseMaterialDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@RestController
@RequestMapping("api/v1/material")
public class CourseMaterialController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseMaterialDTO> saveMaterial(
         @RequestParam("materialIdentity") String materialId,
         @RequestParam String fileName,
         @RequestParam String materialType,
         @RequestParam MultipartFile material,
         @RequestParam(required = false) String uploadAt,
         @RequestParam String courseId

    ){
        var coursMaterial=new CourseMaterialDTO();

        try {
            byte materialToBytes[]=material.getBytes();
            String base64Material= Base64.getEncoder().encodeToString(materialToBytes);

            String uploadTime =uploadAt!=null ? uploadAt: LocalDate.now().format(DateTimeFormatter.ISO_DATE);

            //building the object
            coursMaterial.setCourseId(materialId);
            coursMaterial.setMaterialType(materialType);
            coursMaterial.setFileName(fileName);
            coursMaterial.setMaterial(base64Material);
            coursMaterial.setUploadAt(uploadTime);
            coursMaterial.setCourseId(courseId);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.ok(coursMaterial);




    }

}
