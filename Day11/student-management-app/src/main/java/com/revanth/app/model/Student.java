package com.revanth.app.model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Students")
@Getter
@Setter // Required for Hibernate
@ToString
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
