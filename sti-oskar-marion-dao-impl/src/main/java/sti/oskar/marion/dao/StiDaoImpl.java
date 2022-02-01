package sti.oskar.marion.dao;

import sti.oskar.marion.domain.Student;
import sti.oskar.marion.domain.Teacher;
import sti.oskar.marion.domain.Course;

import java.sql.*;


public class StiDaoImpl implements StiDao{

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    int result = 0;

    @Override
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sti", "root", "root");
    }

    @Override
    public Student createStudent(String firstName, String lastName, int id, String computer){
        try{
            conn = getConnection();
            preparedStatement =conn.prepareStatement("INSERT INTO student ( firstName, lastName, id, computer) VALUES( ?, ?,?,?)");

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);
            preparedStatement.setString(4, computer);

            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return new Student(firstName, lastName, id, computer);
    }
    @Override
    public Course createCourse(int courseCode, int numOfHours, int YHPoints, Teacher teacher){
        try{
            conn = getConnection();
            preparedStatement =conn.prepareStatement("INSERT INTO course ( courseCode, numOfHours,YHPoints, teacher) VALUES( ?, ?,?,?)");

            preparedStatement.setInt(1, courseCode);
            preparedStatement.setInt(2, numOfHours);
            preparedStatement.setInt(3, YHPoints);
            preparedStatement.setInt(4, teacher.getId());

            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return new Course(courseCode, numOfHours, YHPoints, teacher);
    }

    @Override
    public Teacher createTeacher(String firstName, String lastName, int id, int salaryPerHour){
        try{
            conn = getConnection();
            preparedStatement =conn.prepareStatement("INSERT INTO teacher ( firstName, lastName, id, salaryPerHour) VALUES( ?, ?,?,?)");

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);
            preparedStatement.setInt(4, salaryPerHour);

            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return new Teacher(firstName, lastName, id, salaryPerHour);
    }



}