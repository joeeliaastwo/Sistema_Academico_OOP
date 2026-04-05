package model;

public class Teacher extends Person {
    private String specialty;

    public Teacher(String name, String specialty) {
        super(name);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
}