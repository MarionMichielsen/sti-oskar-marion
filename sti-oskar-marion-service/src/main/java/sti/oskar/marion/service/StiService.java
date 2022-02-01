package sti.oskar.marion.service;

import sti.oskar.marion.domain.Course;
import sti.oskar.marion.domain.Student;
import sti.oskar.marion.domain.Teacher;

import java.util.List;

public interface StiService {

    Student createStudent(String firstName, String lastName, int id, String computer, List<Course> courses);
    Teacher createTeacher(String firstName, String lastName, int id, List<Course> courses, int salaryPerHour);
    Course createCourse (int courseCode, int numOfHours, int YHPoints, Teacher teacher);

}
