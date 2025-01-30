package com.revanth.app.controller;

import com.revanth.app.model.Employee;
import com.revanth.app.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
 private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/get/all/employee")
  public Map<String, Employee> getAllEmployees() {
    return employeeService.readAllEmployee();
  }
  @GetMapping("/get/employee")
  public void getAllEmployeeByName() {
  }

  @PostMapping("/create/employee")
  public Employee createEmployees(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @PutMapping("/update/employee")
  public Employee updateEmployee(@RequestParam("id") String id,@RequestParam("age") int age) {
    return employeeService.updateEmployee(id,age);
  }

  @DeleteMapping("/delete/employee")
  public void deleteEmployee(@RequestParam("id") String id) {
   employeeService.deleteEmployee(id);
  }
}
