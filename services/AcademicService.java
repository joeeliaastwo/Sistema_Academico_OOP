package services;

import model.*;
import java.io.Serializable;
import java.util.ArrayList;

// Serializables para guardar listas
public class AcademicService implements Serializable {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments;

    public AcademicService() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

    // 1: Registrar estudiante
    public void registerStudent(String name, String carnet, String major) {
        students.add(new Student(name, carnet, major));
    }

    // 2: Registrar docente
    public void registerTeacher(String name, String specialty) {
        teachers.add(new Teacher(name, specialty));
    }

    // 3: Registrar asignatura
    public void registerCourse(String code, String name, int credits) {
        courses.add(new Course(code, name, credits));
    }

    // 4: Matricular estudiante
    public boolean enrollStudent(String carnet, String courseCode) {
        Student foundStudent = findStudentByCarnet(carnet);
        Course foundCourse = findCourseByCode(courseCode);

        if (foundStudent == null || foundCourse == null) {
            return false; // No existe
        }

        // Solo matriculado una vez
        for (Enrollment e : enrollments) {
            if (e.getStudent().getCarnet().equals(carnet) && e.getCourse().getCode().equals(courseCode)) {
                return false; // Ya matriculado
            }
        }

        enrollments.add(new Enrollment(foundStudent, foundCourse));
        return true;
    }

    // 5: Registrar calificaciones
    public boolean registerGrade(String carnet, String courseCode, double grade) {
        for (Enrollment e : enrollments) {
            if (e.getStudent().getCarnet().equals(carnet) && e.getCourse().getCode().equals(courseCode)) {
                e.setFinalGrade(grade);
                return true;
            }
        }
        return false;
    }

    // 6: Historial académico
    public void showStudentHistory(String carnet) {
        System.out.println("--- Historial Academico ---");
        boolean found = false;
        for (Enrollment e : enrollments) {
            if (e.getStudent().getCarnet().equals(carnet)) {
                found = true;
                String status = e.isGraded() ? String.valueOf(e.getFinalGrade()) : "Sin nota";
                System.out.println("Materia: " + e.getCourse().getName() + " | Nota: " + status);
            }
        }
        if (!found) {
            System.out.println("No hay registros para este estudiante.");
        }
    }

    // 8: Reporte académico
    public void generateStudentReport(String carnet) {
        double sum = 0;
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getStudent().getCarnet().equals(carnet) && e.isGraded()) {
                sum += e.getFinalGrade();
                count++;
            }
        }
        if (count > 0) {
            System.out.println("El promedio del estudiante es: " + (sum / count));
        } else {
            System.out.println("No hay notas registradas para promediar.");
        }
    }

    // auxiliares
    private Student findStudentByCarnet(String carnet) {
        for (Student s : students) {
            if (s.getCarnet().equals(carnet)) return s;
        }
        return null;
    }

    private Course findCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCode().equals(code)) return c;
        }
        return null;
    }
}