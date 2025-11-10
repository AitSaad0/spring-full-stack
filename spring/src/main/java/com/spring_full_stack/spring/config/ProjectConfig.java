package com.spring_full_stack.spring.config;


import com.spring_full_stack.spring.Person;
import com.spring_full_stack.spring.Vehicule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicule vehicule1() {
        Vehicule vehicule = new Vehicule();
        vehicule.setName("Tesla");
        return vehicule;
    }

    //@Bean("saad")
    //public Person person() {
        //Person person = new Person();
        //person.setVehicule(vehicule1());
        //person.setName("saad");
      //  return person;
    //}

    @Bean("saad")
    public Person person(Vehicule vehicule) {
        Person person = new Person();
        person.setVehicule(vehicule);
        person.setName("saad");
        return person;
    }

}
