package model;

public class Student extends Person { // Herencia de Person
    private String carnet;
    private String major;

    public Student(String name, String carnet, String major) {
        super(name); // Llama al constructor de Person
        this.carnet = carnet;
        this.major = major;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getMajor() {
        return major;
    }
}