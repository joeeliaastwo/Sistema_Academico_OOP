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
        this.isGraded = false;
    }

    public void setFinalGrade(double grade) {
        this.finalGrade = grade;
        this.isGraded = true;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public double getFinalGrade() { return finalGrade; }
}