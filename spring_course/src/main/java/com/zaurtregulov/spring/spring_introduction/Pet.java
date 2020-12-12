package com.zaurtregulov.spring.spring_introduction;

public interface Pet {
    default public void say() {
        System.out.println("Pet say");
    }
}
