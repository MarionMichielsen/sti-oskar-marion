package sti.oskar.marion.domain;
import java.sql.SQLOutput;
import java.util.*;

public class App {


    public static void main(String[] args) {

        System.out.println("HEJ!!!");

        Vault vault = new Vault();
        vault.addStudent("Marion", "Michielsen", 872, "Asus");


        Scanner sc = new Scanner(System.in);
        int userInput = 0;

        while (true)
            try {
                System.out.println("Meny; \nSkriv in siffra som motsvarar ditt val. \n1. Hämta en student med id." +
                        "\n2. Registrera en student. \n3. Lägg till eller ta bort kurser från en student");
                userInput = sc.nextInt();

                if (userInput == 1) {
                    System.out.println("Ange id");
                    int id = sc.nextInt();
                    vault.getStudentById(id);
                }

                if (userInput == 2) {
                    System.out.println("Ange förnamn, efternamn, id och dator");
                    String firstName = sc.next();
                    String lastName = sc.next();
                    int id = sc.nextInt();
                    String computer = sc.next();
                    vault.addStudent(firstName, lastName, id, computer);

                    System.out.println("What courses does the student follow?");
                    String name = sc.next();
                    boolean doesCourseExist = false;

                    for (Course course : vault.courses) {
                        if (name.equalsIgnoreCase(course.getName())) {
                            for (Student student : vault.students) {
                                if (id == student.getId()) {
                                    vault.addCourseToStudent(student, course);
                                    doesCourseExist = true;
                                    System.out.println("Student and course added.");
                                }
                            }
                            if (!doesCourseExist) {
                                System.out.println("That course does not exist");
                            }
                        }
                    }
                }

                    if (userInput == 3) {
                        System.out.println("Choice is 3");

                    }



            } catch (InputMismatchException e) {
                System.out.println("Invalid input.  Choose a number from 1-5");
                sc.nextLine();
            }
    }
}