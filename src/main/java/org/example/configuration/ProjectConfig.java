package org.example.configuration;

import org.example.model.Dog;
import org.example.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ProjectConfig {

    //defining a custom annotation
    @Retention(RetentionPolicy.RUNTIME)   //specify that this annotation can be intercepted at runtime. Not possible by default.
    @Target(ElementType.METHOD)           //Set the level at which this annotation should get used. (at method level for this one.)
    public @interface checkAccess {

    }

    @Bean
    Dog dog() {
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
