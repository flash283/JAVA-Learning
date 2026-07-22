package Javase;

import java.io.StringReader;

public abstract class Animal {
    private String name;
    private String cloor;

    public Animal(String cloor, String name) {
        this.cloor = cloor;
        this.name = name;
    }

    public Animal(){}

    public String getCloor() {
        return cloor;
    }

    public void setCloor(String cloor) {
        this.cloor = cloor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void eat();
}
