package services;

import model.Student;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students;
    public StudentService() {
        students = new ArrayList<Student>();
    }
    public void addStudent(String name, String carnet, String career) {
        Student s = new Student(name, carnet, career);
        students.add(s);
    }
    public ArrayList<Student> getAllStudents() {
        return students;
    }
}