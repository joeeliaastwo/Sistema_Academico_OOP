package model;

public class Student extends Person {
    private String carnet;
    private String career;

    public Student(String name, String carnet, String career) {
        super(name);
        this.carnet = carnet;
        this.career = career;
    }

    public String getCarnet() { return carnet; }
    public String getCareer() { return career; }
}