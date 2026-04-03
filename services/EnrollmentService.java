package services;

import model.Course;
import model.Enrollment;
import model.Student;
import java.util.ArrayList;

public class EnrollmentService {
    private ArrayList<Enrollment> enrollments;
    public EnrollmentService(){
        enrollments = new ArrayList<Enrollment>();
    }
    public boolean enroll(Student student, Course course){
        for(int i = 0; i < enrollments.size(); i++){
            Enrollment e = enrollments.get(i);
            if(e.getStudent().equals(student) && e.getCourse().equals(course)){
                return false;
            }
        }

        Enrollment enr = new Enrollment(student, course);
        enrollments.add(enr);
        return true;
    }
    public boolean setGrade(Student student, Course course, double grade){
        for(int i = 0; i < enrollments.size(); i++){
            Enrollment e = enrollments.get(i);
            if(e.getStudent().equals(student) && e.getCourse().equals(course)){
                e.setFinalGrade(grade);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}