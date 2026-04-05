package services;

import model.*;
import java.io.Serializable;
import java.util.ArrayList;

// Esta clase también es Serializable porque guardaremos el estado completo de las listas
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

    // HU-01: Registrar estudiante
    public void registerStudent(String name, String carnet, String major) {
        students.add(new Student(name, carnet, major));
    }

    // HU-02: Registrar docente
    public void registerTeacher(String name, String specialty) {
        teachers.add(new Teacher(name, specialty));
    }

    // HU-03: Registrar asignatura
    public void registerCourse(String code, String name, int credits) {
        courses.add(new Course(code, name, credits));
    }

    // HU-04: Matricular estudiante
    public boolean enrollStudent(String carnet, String courseCode) {
        Student foundStudent = findStudentByCarnet(carnet);
        Course foundCourse = findCourseByCode(courseCode);

        if (foundStudent == null || foundCourse == null) {
            return false; // No se encontró el estudiante o el curso
        }

        // Validación: no matricular dos veces
        for (Enrollment e : enrollments) {
            if (e.getStudent().getCarnet().equals(carnet) && e.getCourse().getCode().equals(courseCode)) {
                return false; // Ya está matriculado
            }
        }

        enrollments.add(new Enrollment(foundStudent, foundCourse));
        return true;
    }

    // HU-05: Registrar calificaciones
    public boolean registerGrade(String carnet, String courseCode, double grade) {
        for (Enrollment e : enrollments) {
            if (e.getStudent().getCarnet().equals(carnet) && e.getCourse().getCode().equals(courseCode)) {
                e.setFinalGrade(grade);
                return true;
            }
        }
        return false;
    }

    // HU-06: Historial académico
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

    // HU-08: Reporte académico (Promedio por estudiante)
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

    // Métodos auxiliares de búsqueda
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