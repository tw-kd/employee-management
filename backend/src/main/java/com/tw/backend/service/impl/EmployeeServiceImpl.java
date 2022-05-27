package com.tw.backend.service.impl;

import com.tw.backend.model.Employee;
import com.tw.backend.repository.EmployeeRepository;
import com.tw.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(Long employeeId) throws Exception {
        return employeeRepository.findById(employeeId).orElseThrow(Exception::new);
    }

    @Override
    public Employee createEmployee(Employee employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employeeDetails) throws Exception {
        Employee employee = getEmployeeByID(employeeId);

        employee.setEmail(employeeDetails.getEmail());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());

        return employeeRepository.save(employee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long employeeId) throws Exception {
        Employee employee = getEmployeeByID(employeeId);
        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
