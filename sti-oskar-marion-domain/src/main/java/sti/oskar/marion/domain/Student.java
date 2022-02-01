package sti.oskar.marion.domain;
import java.util.*;
import java.util.Objects;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int id;
    private final String computer;
    ArrayList<Course> courses = new ArrayList<Course>();



    public Student(String firstName, String lastName, int id, String computer) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.id = id;
        this.computer = Objects.requireNonNull(computer);


    }

    public Student(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.id = builder.id;
        this.computer = builder.computer;

    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getComputer() {
        return computer;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    public static Builder builder(){ return new Builder();}

    public static class Builder {

        private String firstName;
        private String lastName;
        private int id;
        private String computer;


        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder withId(int id) {
            this.id = id;
            return this;
        }
        public Builder withComputer(String computer) {
            this.computer = computer;
            return this;
        }


        public Student build() {
            return new Student(this.firstName, this.lastName, this.id, this.computer);
        }
    }
}

