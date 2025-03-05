package com.rabbit.app;

public class Employee {
  private String name;
  private String empid;
  private int age;
  public String getEmpid() {
    return empid;
  }

  public void setEmpid(String empid) {
    this.empid = empid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee [name=" + name + ", empid=" + empid + ", age=" + age + "]";
  }
}
