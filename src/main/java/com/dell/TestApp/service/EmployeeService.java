package com.dell.TestApp.service;

import com.dell.TestApp.dao.EmployeeRepository;
import com.dell.TestApp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean add(Employee employee)
    {
        employeeRepository.save(employee);
        return true;
    }

    public String getAll()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        String response="";
        for (Employee employee:
             employeeList ) {
            response+=employee.toString();
        }
        return response;
    }
}
