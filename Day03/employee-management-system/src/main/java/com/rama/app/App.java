package com.rama.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
class Employee{
    String name;
    int age;
    String company;
    String id;
    int salary;

    public Employee(String name, int age, String company, String id, int salary) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.id = id;
        this.salary = salary;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void print(){
        System.out.println("name : "+ name);
        System.out.println("age : "+ age);
        System.out.println("company : "+ company);
        System.out.println("id : "+ id);
        System.out.println("salary : "+ salary);
    }
}




public class App
{
    public static void main(String args[]){
        List<Employee> employees=new ArrayList<>();
        Employee emp1=new Employee("Revanth",22,"Tcs","r12",55000);
        Employee emp2=new Employee("Sandhya",21,"infosys","s43",25000);
        Employee emp3=new Employee("Shivani",31,"wipro","s56",30000);
        Employee emp4=new Employee("Murali",23,"capgemini","m21",40000);
        Employee emp5=new Employee("Bhanu",32,"google","b64",51000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        System.out.println("----Employees age less than 30----");
        List<Employee> ageless30=employees.stream()
                .filter(employee->employee.getAge()<30)
                .collect(Collectors.toList());
        for(Employee emp:ageless30){
                emp.print();
                System.out.println("----------------------");
        }

        System.out.println("----Employees Salary greater than 50000----");
        List<Employee> salarygrater50k=employees.stream()
                .filter(employee->employee.getSalary()>50000)
                .collect(Collectors.toList());
        for(Employee emp:salarygrater50k){
            emp.print();
            System.out.println("----------------------");
        }

        System.out.println("----(Map)Employees Salary less than 40000----");
        Map<String,Employee> salaryless40k=employees.stream()
                .filter(employee -> employee.getSalary()<40000)
                .collect(Collectors.toMap(Employee::getName,emp->emp));
        System.out.println(salaryless40k);

        System.out.println("----(Map)Employees age greater thant 25----");
        Map<String,Employee> agegrater25=employees.stream()
                .filter(employee -> employee.getAge()>25)
                .collect(Collectors.toMap(Employee::getName,emp->emp));
        System.out.println(agegrater25);

    }
}
