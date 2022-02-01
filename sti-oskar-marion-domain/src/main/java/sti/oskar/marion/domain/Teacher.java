package sti.oskar.marion.domain;
import java.util.*;
import java.util.Objects;

public class Teacher {
    private final String firstName;
    private final String lastName;
    private final int id;
    ArrayList<Course> courses = new ArrayList<>();
    private final int salaryPerHour;

    public Teacher (String firstName, String lastName, int id, int salaryPerHour ){
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.id = id;
        this.salaryPerHour = salaryPerHour;

    }

    public Teacher (Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.id = builder.id;
        this.salaryPerHour = builder.salaryPerHour;

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getId(){
        return id;
    }

    public List<Course> getCourses(){
        return courses;
    }

    public int getSalaryPerHour(){
        return salaryPerHour;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private int id;
        private int salaryPerHour;

        public Builder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder withId(int id){
            this.id = id;
            return this;
        }



        public Teacher build(){
            return new Teacher(this.firstName, this.lastName, this.id, this.salaryPerHour);
        }

    }
}
