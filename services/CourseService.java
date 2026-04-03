package services;

import model.Course;
import java.util.ArrayList;

public class CourseService {
    private ArrayList<Course> courses;
    public CourseService() {
        courses = new ArrayList<Course>();
    }
    public void addCourse(String code, String name, int credits) {
        Course c = new Course(code, name, credits);
        courses.add(c);
    }
    public ArrayList<Course> getAllCourses() {
        return courses;
    }
}