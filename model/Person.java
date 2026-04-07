package model;
import java.io.Serializable; // Serializador para convertir a bytes

public class Person implements Serializable {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}  // Esta es nuestra clase principal