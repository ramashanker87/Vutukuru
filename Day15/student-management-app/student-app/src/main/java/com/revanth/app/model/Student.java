package com.revanth.app.model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Students")
// Required for Hibernate

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
   private String name;
    @Column(nullable = false)
   private String schoolName;
    @Column(nullable = false)
   private int age;
    @Column(nullable = false)
   private String gender;

    public Student() {
    }

    public Student(String name, String schoolName, int age, String gender) {
        this.name = name;
        this.schoolName = schoolName;
        this.age = age;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

}
