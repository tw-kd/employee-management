package com.tw.backend.controller;

import com.tw.backend.model.Employee;
import com.tw.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //    get employees
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //    get employee by ID
    @GetMapping("employee/{id}")
    public Employee getEmployeeByID(@PathVariable(value = "id") Long employeeId) throws Exception {
        return employeeService.getEmployeeByID(employeeId);
    }

    //    create employee
    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employeeDetails) {
        return employeeService.createEmployee(employeeDetails);
    }

    //    update employee
    @PutMapping("employee/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody Employee employeeDetails) throws Exception {
        return employeeService.updateEmployee(employeeId, employeeDetails);
    }

    //    delete employee
    @DeleteMapping("employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
        return employeeService.deleteEmployee(employeeId);
    }
}
