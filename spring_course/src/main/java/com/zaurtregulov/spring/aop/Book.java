package com.zaurtregulov.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("Преступление и наказание")
    private String name;

    @Value("Ф.М. Достоевский")
    private String author;

    @Value("1866")
    private int yearsOfPublication;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearsOfPublication() {
        return yearsOfPublication;
    }

    public void setYearsOfPublication(int yearsOfPublication) {
        this.yearsOfPublication = yearsOfPublication;
    }
}
