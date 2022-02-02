package sti.oskar.marion.domain;
import java.util.*;

public class Vault {

    List<Student> students = addStudents();
    List<Teacher> teachers = addTeachers();
    List<Course> courses = addCourses();

    static Student s1 = new Student("Anders", "Svensson", 90, "Apple");
    static Student s2 = new Student("Maja", "Andersson", 78, "Lenovo");
    static Student s3 = new Student("Ola", "Karlsson", 55, "Acer");

    static Teacher t1 = new Teacher("Sven", "Kramer", 121, 999);
    static Teacher t2 = new Teacher("Ireen", "Wust", 298, 1500);
    static Teacher t3 = new Teacher("Patrik", "Roest", 817, 800);


    static Course c1 = new Course("Databashantering", 966, 25, 50, t1);
    static Course c2 = new Course("HTML", 3, 160, 20, t2);
    static Course c3 = new Course("JavaScript", 45, 150, 30, t3);

    public void addStudent(String firstName, String lastName, int id, String computer) {
        Student s = new Student(firstName, lastName, id, computer);
        students.add(s);
    }

    public static ArrayList<Student> addStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        return students;
    }

    public static ArrayList<Teacher> addTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);

        return teachers;
    }

    public static ArrayList<Course> addCourses() {
        ArrayList<Course> courses = new ArrayList<>();
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

    public void getStudentById(int id) {
        for (Student stud : students) {
            if (stud.getId() == id) {
                System.out.println(stud.getFirstName() + " " + stud.getLastName() + " ");
                for (Course c : stud.courses) {
                    System.out.println(c.getName());
                }
            } else
                System.out.println("id not found....");
            break;
        }
    }
}

