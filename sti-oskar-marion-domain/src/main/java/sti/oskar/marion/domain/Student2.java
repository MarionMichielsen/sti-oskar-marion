package sti.oskar.marion.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student2 {

    private String firstName;
    private String lastName;
    private int id;
    private String computer;
    private Course courses;

    public Student2(String firstName, String lastName, int id, String computer){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.computer = computer;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

}
