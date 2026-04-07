package model;

public class Teacher extends Person { // Herencia de la clase Person
    private String specialty;

    public Teacher(String name, String specialty) {
        super(name); // Llama al constructor Person
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
}