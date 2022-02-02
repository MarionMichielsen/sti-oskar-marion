package sti.oskar.marion.swagger.endpoint.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import sti.oskar.marion.domain.Student;
import sti.oskar.marion.domain.Teacher;
import sti.oskar.marion.domain.Course;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sti.oskar.marion.service.StiService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(value = "Student, Teacher, Course Controller")
@RestController
@RequestMapping("/api/service")
public class RestService {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:sti-oskar-marion-service.xml");
    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);

    private static List<Student> students;
    private static List<Teacher> teachers;
    private StiService stiService;



    public RestService(){
        stiService = (StiService)applicationContext.getBean("stiService");

        students = Arrays.asList(
                new Student("Nasir", "Tedros", 124, "Apple"),
                new Student ("Oskar", "Wadin", 92284, "Windows"),
                new Student("Luliya", "Masfun", 429, "Asus"));

        teachers=Arrays.asList(
                new Teacher("Sven" , "Kramer", 8783, 250),
                new Teacher("Ireen", "Wust", 2132, 700),
                new Teacher ("Patrik", "Roest", 2563, 1220));

        /*        Student.builder()
                        .withFirstName("Max")
                        .withLastName("Lundin")
                        .wi

                        .build()*/

        LOGGER.info("RestService created");
    }

    @GetMapping(("/getStudentNames"))
    @ApiOperation(value = "Gets the names of all students")
    public List<String> getStudentNames(){
        //TODO: refactor Java 7 for-loop to Java 8 stream
        List<String> studentNames = new ArrayList<>();
        for(Student student : students){
            studentNames.add(student.toString());
        }
        return studentNames;
    }


    @GetMapping("/getStudentbyfirstName")
    @ApiOperation(value = "Takes a given name as input and returns the student information")
    public Student getStudentbyFirstName(@RequestParam String firstName){
        Student student = null;
        for(Student s : students){
            if(s.getFirstName().equalsIgnoreCase(firstName)){
                student = s;
            }
        }
        return student;
    }

    @PostMapping("/addnewstudent")
    @ApiOperation(value = "Adds a new student")
    public void createStudent(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int id,
            @RequestParam String computer ) {
        stiService.createStudent(firstName, lastName, id, computer);
      //  students.add(new Student(newStudent.getFirstName(), newStudent.getLastName(), newStudent.getId(), newStudent.getComputer()));
    }

    @PostMapping("/addnewteacher")
    @ApiOperation(value = "Adds a new Teacher")
    public void createTeacher(@RequestBody Teacher newTeacher){
        teachers.add(new Teacher(newTeacher.getFirstName(), newTeacher.getLastName(), newTeacher.getId(), newTeacher.getSalaryPerHour()));
    }

}

