package sti.oskar.marion.domain;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            try{
                System.out.println("Meny: \nSkriv in siffra som motsvarar ditt val." +
                "\n1. Hämta en student med id.\n2. Registrera en student." +
                        "\n3. Lägg till eller ta bort kurser från en student");

                int userInput = sc.nextInt();
                if(userInput == 1){
                    System.out.println("Ange id");
                    int id = sc.nextInt();
                    Vault.getStudentById(id);
                }

                if(userInput == 2){
                    System.out.println("Ange förnamn, efternamn, id och dator");
                    String firstName = sc.nextLine();
                    String lastName = sc.nextLine();
                    int id = sc.nextInt();
                    String computer = sc.next();
                    Vault.addStudent(firstName, lastName, id, computer);
                    System.out.println("Vilka kurser tar studenten?");
                    String name = sc.next();
                        for(course : courses)
                }

                if(userInput == 3) {
                    System.out.println("För vilken student vill du ändra kurser?\nAnge id");
                    int id = sc.nextInt();
                    for(choice : ) {
                        System.out.println(student.firstName);
                    }
                }





        /*while(true) {
            while(true) {
                try {
                    System.out.println("Meny; \nSkriv in siffra som motsvarar ditt val." +
                            "\n1. HÃmta en student med id.\n2. Registrera en student." +
                            "\n3. LÃgg till eller ta bort kurser frÃ¥n en student");
                    int userInput = sc.nextInt();
                    if (userInput == 1) {
                        System.out.println("Ange id");
                        int id = sc.nextInt();
                        vault.getStudentById(id);
                    }*/

                    if (userInput == 2) {
                        System.out.println("Ange fÃ¶rnamn, efternamn, id och dator");
                        String firstName = sc.next();
                        String lastName = sc.next();


                        System.out.println("What courses does the student follow?");
                        String name = sc.next();
                        boolean doesCourseExist = false;
                        Iterator var10 = vault.courses.iterator();

                        label44:
                        while(true) {
                            Course course;
                            do {
                                if (!var10.hasNext()) {
                                    break label44;
                                }

                                course = (Course)var10.next();
                            } while(!name.equalsIgnoreCase(course.getName()));

                            Iterator var12 = vault.students.iterator();

                            while(var12.hasNext()) {
                                Student student = (Student)var12.next();
                                if (id == student.getId()) {
                                    Vault.addCourseToStudent(student, course);
                                    doesCourseExist = true;
                                    System.out.println("Student and course added.");
                                }
                            }

                            if (!doesCourseExist) {
                                System.out.println("That course does not exist");
                            }
                        }
                    }

                    if (userInput == 3) {
                        System.out.println("Choice is 3");
                    }
                } catch (InputMismatchException var14) {
                    System.out.println("Invalid input.  Choose a number from 1-5");
                    sc.nextLine();
                }
            }
        }


    }
}
