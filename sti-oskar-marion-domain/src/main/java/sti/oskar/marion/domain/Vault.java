package sti.oskar.marion.domain;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vault {
    static Student s1 = new Student("Anders", "Svensson", 90, "Apple");
    static Student s2 = new Student("Maja", "Andersson", 78, "Lenovo");
    static Student s3 = new Student("Ola", "Karlsson", 55, "Acer");

    static Teacher t1 = new Teacher("Sven", "Kramer", 121, 999);
    static Teacher t2 = new Teacher("Ireen", "Wust", 298, 1500);
    static Teacher t3 = new Teacher("Patrik", "Roest", 817, 800);

    static Course c1 = new Course("HTML" ,100 ,160 ,30 , t1);
    static Course c2 = new Course("Java", 110, 180, 35, t2);
    static Course c3 = new Course("Databashantering", 120, 160, 30, t3);

    static List<Student> students = addStudents();
    static List<Teacher> teachers = addTeachers();
    static List<Course> courses = addCourses();

    public Vault() {
    }

    public static List<Student>getStudents() {
        return students;
    }

    public static List<Course>getCourses() {
        return courses;
    }

    public static void addStudent(String firstName, String lastName, int id, String computer) {
        Student s = new Student(firstName, lastName, id, computer);
        students.add(s);
    }

    public static List<Student> addStudents() {
        students.add(s1);
        students.add(s2);
        students.add(s3);
        return students;
    }

    public static List<Teacher> addTeachers() {
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        return teachers;
    }

    public static List<Course> addCourses() {
        courses.add(c1);
        courses.add(c1);
        courses.add(c1);
        return courses;
    }

    public static void addAllCoursesToStudent() {
        s1.courses.add(c1);
        s1.courses.add(c2);
        s2.courses.add(c1);
        s3.courses.add(c3);
        s2.courses.add(c3);
        s3.courses.add(c2);
    }

    public static void addCourseToStudent(Student student, Course course) {
        student.courses.add(course);
    }

    public static void deleteCourseFromStudent(Student student, Course course) {
        student.courses.remove(course);
    }

    public static String getStudentById(int id) {
      for (Student student: students ){
          if (id == student.getId())
              return student.getFirstName()+" "+student.getLastName();
            }
                return "id not found....";
            }
        }





