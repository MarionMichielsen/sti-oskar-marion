package sti.oskar.marion.domain;
import java.util.*;
import java.util.Objects;

public class Course {

    private final String name;
    private final int courseCode;
    private final int numOfHours;
    private final int YHPoints;
    private final Teacher teacher;

    public Course(String name, int courseCode, int numOfHours, int YHPoints, Teacher teacher) {
        this.name=name;
        this.courseCode = courseCode;
        this.numOfHours = numOfHours;
        this.YHPoints = YHPoints;
        this.teacher = Objects.requireNonNull(teacher);
    }

    public String getName(){ return name; }
    public int getCourseCode() {
        return courseCode;
    }

    public int getNumOfHours() {
        return numOfHours;
    }

    public int getYHPoints() {
        return YHPoints;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course(Builder builder) {
        this.name= builder.name;
        this.courseCode = builder.courseCode;
        this.YHPoints = builder.YHPoints;
        this.numOfHours = builder.numOfHours;
        this.teacher = builder.teacher;
    }

    @Override
    public String toString() {
        return courseCode + " " + YHPoints;
    }

    public static Course.Builder builder() {
        return new Course.Builder();
    }

    public static class Builder {
        private String name;
        private int courseCode;
        private int numOfHours;
        private int YHPoints;
        private Teacher teacher;

        public Course.Builder withName(String name){
            this.name=name;
            return this;
        }

        public Course.Builder withCourseCode(int courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public Course.Builder withNumOfHours(int numOfHours) {
            this.numOfHours = numOfHours;
            return this;
        }

        public Course.Builder withYHPoints(int YHPoints) {
            this.YHPoints = YHPoints;
            return this;
        }

        public Course.Builder withTeacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public Course build() {
            return new Course(this.name, this.courseCode, this.numOfHours, this.YHPoints, this.teacher);
        }


    }
}
