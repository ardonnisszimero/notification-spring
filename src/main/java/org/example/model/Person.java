package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;


    //field injection
    @Autowired
    private Dog pet;            //after the bean for this class get creating. spring will inject dog bean here. So we
                                //can't mark it as final.

    public Person() {
        this.name = "John";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPet(Dog pet) {
        this.pet = pet;
    }

    public Dog getPet() {
        return pet;
    }

}
