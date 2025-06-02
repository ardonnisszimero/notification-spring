package org.example.model;

public class Dog {
    private String name;
    private int age;
    private Person owner;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {

    }

    public Person getOwner() {
        return owner;
    }
}
