package model;

public class Teacher extends Person {
    private final String specialty;

    public Teacher(String name, String specialty) {
        super(name);
        this.specialty = specialty;
    }

    public String getSpecialty() { return specialty; }
}