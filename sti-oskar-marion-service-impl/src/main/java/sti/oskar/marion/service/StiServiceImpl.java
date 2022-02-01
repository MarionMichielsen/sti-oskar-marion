package sti.oskar.marion.service;
import sti.oskar.marion.domain.Student;
import sti.oskar.marion.domain.Course;
import sti.oskar.marion.domain.Teacher;
import java.util.*;

public class StiServiceImpl implements StiService {

    @Override
    public Student createStudent(String firstName, String lastName, int id, String computer){
        Student student = new Student(firstName, lastName, id, computer);
        return student;
    }

    @Override
    public Course createCourse(int courseCode, int numOfHours, int YHPoints, Teacher teacher){
        Course course = new Course ( courseCode, numOfHours, YHPoints, teacher);
        return course;
    }

    @Override
    public Teacher createTeacher(String firstName, String lastName, int id, int salaryPerHour){
        Teacher teacher = new Teacher(firstName, lastName, id, salaryPerHour );
        return teacher;
    }
}

