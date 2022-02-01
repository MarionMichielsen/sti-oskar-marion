package sti.oskar.marion.domain;

import java.util.*;

public class Teacher {
    private final String firstName;
    private final String lastName;
    private final int id;
    private final List<Course> courses;
    private final int salaryPerHour;

    public Teacher (String firstName, String lastName, int id, List<Course> courses, int salaryPerHour ){
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.id = id;
        this.courses = Objects.requireNonNull(courses);
        this.salaryPerHour = salaryPerHour;

    }

    public Teacher (Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.id = builder.id;
        this.courses = builder.courses;
        this.salaryPerHour = builder.salaryPerHour;

}
