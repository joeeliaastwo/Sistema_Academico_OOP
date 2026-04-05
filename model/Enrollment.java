package model;

import java.io.Serializable;

public class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private double finalGrade;
    private boolean isGraded;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.finalGrade = 0.0;
        this.isGraded = false; // Bandera para saber si ya le pusieron nota
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
        this.isGraded = true;
    }
}