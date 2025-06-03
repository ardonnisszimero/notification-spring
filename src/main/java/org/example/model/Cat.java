package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    private String name;
    private final  Person owner;
    private Dog friend;


    //constructor injection
    @Autowired
    public Cat(@Qualifier("person") Person owner) {  //this is the standard way to inject beans. this gets injected
                                                        //DURING the time spring creates the object to add to it's context.
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public Dog getFriend() {
        return friend;
    }

    //setter injection - avoid at all cost.
    @Autowired
    public void setFriend(Dog friend) {
        this.friend = friend;
    }
}
