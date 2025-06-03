package org.example;

import org.example.configuration.ProjectConfig;
import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Dog dog = context.getBean(Dog.class); //only works if there's is one bean of this class, otherwise you'd have
        //to specify the name of the bean as well

        Person person = context.getBean("person",Person.class);  //the bean got adding to the context through component scanning

        Cat cat = context.getBean("cat",Cat.class);

        //adding cat to the spring context programmatically.
        Cat c = new Cat(person);
        Supplier<Cat> catSupplier = () -> c;
        context.registerBean("c", Cat.class, catSupplier);


        Cat cc = context.getBean("c", Cat.class);


        System.out.println(dog);
        System.out.println(person);
        System.out.println(cc);


        Person aPerson = context.getBean("aPerson", Person.class);

        //proof that aPerson name has the dog bean above wired
        System.out.println(aPerson.getPet().getName());
        dog.setName("lighting");
        //changing the name on dog bean will also change the dog on the person object.
        System.out.println(aPerson.getPet().getName());

        //dog is injected into person through field injection
        System.out.println(person.getPet().getName());

        //person is injected into cat through contructor injection
        System.out.println(cat.getOwner().getName());

        //dog in injected into cat through setter injection. ewww.
        System.out.println(cat.getFriend().getName());

    }
}
