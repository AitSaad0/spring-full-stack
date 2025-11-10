package com.spring_full_stack.spring;


import com.spring_full_stack.spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ObjectInputFilter;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Vehicule Tesla = context.getBean(Vehicule.class);

        System.out.println(person.getName() + " had a " + person.getVehicule());

    }
}