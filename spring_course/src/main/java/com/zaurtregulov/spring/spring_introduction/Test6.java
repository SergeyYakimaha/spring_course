package com.zaurtregulov.spring.spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.security.auth.login.AccountLockedException;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//        Pet cat1 = context.getBean("catBean", Pet.class);
//        Pet cat2 = context.getBean("catBean", Pet.class);

//        cat.say();

        Person person1 = context.getBean("personBean", Person.class);
        Person person2 = context.getBean("personBean", Person.class);
//        person.callYourPet();

        System.out.println(person1.getSurname());
        System.out.println(person1.getAge());

        System.out.println(person1.getPet());
        System.out.println(person2.getPet());

        System.out.println(person1);
        System.out.println(person2);

        context.close();
    }
}
