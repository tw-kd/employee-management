package com.tw.backend.service;

import com.tw.backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeByID(Long employeeId) throws Exception;

    Employee createEmployee(Employee employeeDetails);

    Employee updateEmployee(Long employeeId, Employee employeeDetails) throws Exception;

    Map<String, Boolean> deleteEmployee(Long employeeId) throws Exception;

}
