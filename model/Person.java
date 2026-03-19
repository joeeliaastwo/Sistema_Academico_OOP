package model;
import java.io.Serializable;

public abstract class Person implements Serializable {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}