package services;

import model.Teacher;
import java.util.ArrayList;

public class TeacherService {
    private ArrayList<Teacher> teachers;
    public TeacherService(){
        teachers = new ArrayList<Teacher>();
    }
    public void addTeacher(String name, String specialty){
        Teacher t = new Teacher(name, specialty);
        teachers.add(t);
    }
    public ArrayList<Teacher> getAllTeachers(){
        return teachers;
    }
}