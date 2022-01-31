package sti.oskar.marion.domain;
import java.util.*;
import java.util.Objects;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int id;
    private final String computer;
    private final List<Course> courses;

    public Student(String firstName, String lastName, int id, String computer, List<Course> courses) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.id = Objects.requireNonNull(id);
        this.computer = Objects.requireNonNull(computer);
        this.courses = Objects.requireNonNull(courses);

    }

    public Student(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.id = builder.id;
        this.computer = builder.computer;
        this.courses= builder.courses;
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

    //nested class / nästlad klass / inner class /inre klass
    public static class Builder {

        private String firstName;
        private String lastName;
        private int id;
        private String computer;
        private List<Course> courses;

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
        public Builder withCourses(List<Course> courses) {
            this.courses = courses;
            return this;
        }

        public Student build() {
            return new Student(this.firstName, this.lastName, this.id, this.computer, this.courses);
        }
    }
}

