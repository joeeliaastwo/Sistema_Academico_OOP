package presentation;

import services.AcademicService;
import storage.FileStorage;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "data.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AcademicService service = null;

        // HU-07: Cargar datos al iniciar
        System.out.println("Cargando sistema...");
        Object loadedData = FileStorage.loadData(FILE_NAME);
        if (loadedData != null && loadedData instanceof AcademicService) {
            service = (AcademicService) loadedData;
            System.out.println("Datos cargados exitosamente.");
        } else {
            service = new AcademicService();
            System.out.println("Iniciando sistema desde cero.");
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== SISTEMA ACADEMICO ESEN ===");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Registrar Docente");
            System.out.println("3. Registrar Asignatura");
            System.out.println("4. Matricular Estudiante");
            System.out.println("5. Registrar Calificacion");
            System.out.println("6. Ver Historial de Estudiante");
            System.out.println("7. Generar Reporte (Promedio)");
            System.out.println("8. Guardar y Salir");
            System.out.print("Elige una opcion: ");

            // Usamos nextLine y parseamos para evitar el bug del Scanner de Java
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Nombre: ");
                    String sName = scanner.nextLine();
                    System.out.print("Carnet: ");
                    String carnet = scanner.nextLine();
                    System.out.print("Carrera: ");
                    String major = scanner.nextLine();
                    service.registerStudent(sName, carnet, major);
                    System.out.println("Estudiante registrado.");
                    break;
                case "2":
                    System.out.print("Nombre: ");
                    String tName = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String specialty = scanner.nextLine();
                    service.registerTeacher(tName, specialty);
                    System.out.println("Docente registrado.");
                    break;
                case "3":
                    System.out.print("Codigo de curso: ");
                    String cCode = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String cName = scanner.nextLine();
                    System.out.print("Creditos: ");
                    int credits = Integer.parseInt(scanner.nextLine());
                    service.registerCourse(cCode, cName, credits);
                    System.out.println("Asignatura registrada.");
                    break;
                case "4":
                    System.out.print("Carnet del estudiante: ");
                    String eCarnet = scanner.nextLine();
                    System.out.print("Codigo de curso: ");
                    String eCode = scanner.nextLine();
                    if (service.enrollStudent(eCarnet, eCode)) {
                        System.out.println("Matricula exitosa.");
                    } else {
                        System.out.println("Error: Datos invalidos o el estudiante ya esta matriculado.");
                    }
                    break;
                case "5":
                    System.out.print("Carnet del estudiante: ");
                    String gCarnet = scanner.nextLine();
                    System.out.print("Codigo de curso: ");
                    String gCode = scanner.nextLine();
                    System.out.print("Nota final: ");
                    double grade = Double.parseDouble(scanner.nextLine());
                    if (service.registerGrade(gCarnet, gCode, grade)) {
                        System.out.println("Nota guardada.");
                    } else {
                        System.out.println("Error: No se encontro la matricula.");
                    }
                    break;
                case "6":
                    System.out.print("Carnet del estudiante: ");
                    String hCarnet = scanner.nextLine();
                    service.showStudentHistory(hCarnet);
                    break;
                case "7":
                    System.out.print("Carnet del estudiante: ");
                    String rCarnet = scanner.nextLine();
                    service.generateStudentReport(rCarnet);
                    break;
                case "8":
                    // HU-07: Guardar datos al salir
                    FileStorage.saveData(service, FILE_NAME);
                    System.out.println("Datos guardados. Saliendo del sistema...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }
}