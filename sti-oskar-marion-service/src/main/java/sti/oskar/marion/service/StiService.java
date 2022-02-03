package sti.oskar.marion.service;

import sti.oskar.marion.domain.App;
import sti.oskar.marion.domain.Course;
import sti.oskar.marion.domain.Student;
import sti.oskar.marion.domain.Teacher;

public interface StiService {

    Student createStudent(String firstName, String lastName, int id, String computer);
    Teacher createTeacher(String firstName, String lastName, int id,  int salaryPerHour);
    Course createCourse (String name, int courseCode, int numOfHours, int YHPoints, Teacher teacher);

    public Course addCourseToStudent(Course course, Student student);

    public static void main(String[] args) {
        App start = new App();
        start.run();


    }

}
