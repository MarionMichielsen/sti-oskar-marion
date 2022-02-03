package sti.oskar.marion.swagger.endpoint.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import sti.oskar.marion.dao.StiDaoImpl;
import sti.oskar.marion.domain.Student;
import sti.oskar.marion.domain.Teacher;
import sti.oskar.marion.domain.Course;
import sti.oskar.marion.service.StiService;
import sti.oskar.marion.service.StiServiceImpl;
import sti.oskar.marion.domain.Vault;

import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static sti.oskar.marion.domain.Student.courses;

@Api(value = "Student, Teacher, Course Controller")
@RestController
@RequestMapping("/api/service")
public class RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);
    private final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "classpath:sti-oskar-marion-service.xml");
    private static StiService stiService;
 //   private static StiDaoImpl stiDaoImpl;


    private static List<Student> students;
    private static List<Teacher> teachers;
    private static List<Course> courses;

    public RestService() throws SQLException {

        stiService = (StiService) applicationContext.getBean("stiServiceBean");
        //   this.stiDaoImpl = (StiDaoImpl)this.applicationContext.getBean("stiDaoBean");
        //  stiDaoImpl.loadStudents();

      /*  students = Arrays.asList(
                new Student("Nasir", "Tedros", 8921, "Apple"),
                new Student("Oskar", "Wadin", 92284, "Windows"),
                new Student("Luliya", "Masfun", 429, "Asus"));

        teachers = Arrays.asList(
                new Teacher("Sven", "Kramer", 8783, 250),
                new Teacher("Ireen", "Wust", 2132, 700),
                new Teacher("Patrik", "Roest", 2563, 1220));*/

        /*        Student.builder()
                        .withFirstName("Max")
                        .withLastName("Lundin")
                        .wi

                        .build()*/

        LOGGER.info("RestService created");

    }


    @GetMapping(("/getStudentNames"))
    @ApiOperation(value = "Gets the names of all students")
        public List<String> getStudentNames() {
        List<String> studentNames = new ArrayList<>();
        for (Student student : Vault.getStudents()) {
            studentNames.add(student.toString());
        }
        return studentNames;

    }

    /*@GetMapping("/getStudentbyid")
    @ApiOperation(value = "Takes an id as input and returns the student information")
    public String getStudentbyId(@RequestParam int id) {
        return Vault.getStudentById(id);
    }*/

    @PostMapping("/addnewstudent")
    @ApiOperation(value = "Adds a new student")
    public void createStudent(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int id,
            @RequestParam String computer) {


        stiService.createStudent(firstName, lastName, id, computer);
      //  this.stiDaoImpl.createStudent(firstName, lastName, id, computer);
    }

    /*@PostMapping("/addnewteacher")
    @ApiOperation(value = "Adds a new Teacher")
    public void createTeacher(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam int id,
                              @RequestParam int salaryPerHour) {
        teachers.add(stiService.createTeacher(firstName, lastName, id, salaryPerHour));
    }*/

    @PostMapping("/addcoursetostudent")
    @ApiOperation(value = "Adds a course to an existing student")
    public void addCourseToStudent(@RequestParam String firstName,
                                   @RequestParam String name) {
        Student student = null;
        Course course = null;
        for (Student s : Vault.getStudents()) {
            if (s.getFirstName().equalsIgnoreCase(firstName)) {
                student = s;
            }
        }
        for (Course c : Vault.getCourses()) {
            if (c.getName().equalsIgnoreCase(name)) {
                course = c;
            }
        }
        if (student == null || course == null)
            System.out.println("That course or student did not exist.");
        else if (student != null && course != null)
            stiService.addCourseToStudent(course, student);
    }
}
