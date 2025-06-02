package org.example.configuration;

import org.example.model.Dog;
import org.example.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

    @Bean
    Dog dog() {
        System.out.println("Dog");
        var d = new Dog();
        d.setName("Cole");
        return d;
    }

    @Bean
    Person aPerson() {
        var p = new Person();
        p.setName("Ardonniss");
        p.setPet(dog());        //looks weird here but know that since the dog bean already exists and got adding to
                                //spring context. We aren't creating a new instance of Dog here.
        return p;
    }


    //another way to wire bean for Person object using the constructor of bean creation method.
    //constructor injection btw - which is a form of dependency injection.
    @Bean
    Person bPerson(Dog d) {
        var p = new Person();
        p.setName("Ardonniss");
        p.setPet(d);
        return p;
    }
}
