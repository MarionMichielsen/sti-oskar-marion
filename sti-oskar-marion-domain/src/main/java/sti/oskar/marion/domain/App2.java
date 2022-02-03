package sti.oskar.marion.domain;
import java.util.Locale;
import java.util.Scanner;

public class App2 {

    public void run(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Meny: \nSkriv in siffra som motsvarar ditt val. \n" +
                "1. Hämta en student med id.\n" +
                "2. Registrera en student. \n" +
                "3. Lägg till eller ta bort kurser från en student");

        int userResponse = sc.nextInt();

        if(userResponse == 1){
            System.out.println("Vilken student vill du hämta? Ange id.");
            int id = sc.nextInt();
            Vault.getStudentById(id);

        }

        if(userResponse == 2){
            System.out.println("Ange förnamn, efternamn, id och dator.");
            String firstName = sc.nextLine();
            String lastName = sc.nextLine();
            int id = sc.nextInt();
            String computer = sc.nextLine();

        }

        if(userResponse == 3){
            System.out.println("Vilken student vill du hämta? Ange id.");
            int id = sc.nextInt();
            Vault.getStudentById(id);
            System.out.println("Vill du lägga till eller ta bort en kurs?");
            String addOrRemove = sc.nextLine();
                if(
        }

    }
}
