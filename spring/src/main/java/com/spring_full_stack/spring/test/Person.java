package com.spring_full_stack.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;
    private Vehicule vehicule;
    @Autowired
    public Person(Vehicule vehicule){
        this.name = "Saad";
        this.vehicule = vehicule;
        System.out.println("The Person has been vehicule");
    }

    public Vehicule getVehicule() {
        return vehicule;
    }
}
