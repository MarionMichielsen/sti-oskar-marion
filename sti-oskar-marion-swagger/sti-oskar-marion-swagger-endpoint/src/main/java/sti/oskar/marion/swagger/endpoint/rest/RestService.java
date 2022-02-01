package sti.oskar.marion.swagger.endpoint.rest;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import sti.oskar.marion.domain.Student;
/*import sti.spring.boot.swagger.endpoint.domain.Student;*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/service")
public class RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);

    private static List<Student> students;

    public RestService(){
        students = Arrays.asList(
                new Student("Nasir", "Tedros", 124, "Apple"),
                new Student ("Oskar", "Wadin", 92284, "Windows"),
                new Student("Luliya", "Masfun", 429, "Asus"));

        /*        Student.builder()
                        .withFirstName("Max")
                        .withLastName("Lundin")
                        .wi

                        .build()*/

        LOGGER.info("RestService created");
    }
}
