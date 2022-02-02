package sti.oskar.marion.dao;
import sti.oskar.marion.domain.Student;
import sti.oskar.marion.domain.Teacher;
import sti.oskar.marion.domain.Course;
import java.sql.Connection;
import java.sql.SQLException;

public interface StiDao {

    Connection getConnection() throws SQLException;



    Student createStudent(String firstName, String lastName, int id, String computer);
    Course createCourse(String name, int courseCode, int numOfHours, int YHPoints, Teacher teacher);
    Teacher createTeacher(String firstName, String lastName, int id, int salaryPerHour);

  //  boolean deleteStudent(String firstName, String lastName, int id, String computer);
  //  boolean deleteTeacher(String firstName, String lastName, int id, int salaryPerHour);
  //  boolean deleteCourse(int courseCode, int numOfHours, int YHPoints, Teacher teacher);

    }

