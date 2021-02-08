package com.dell.TestApp.controller;

import com.dell.TestApp.entities.Employee;
import com.dell.TestApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public String SaveEmployee(@RequestBody Employee employee){
        if( employeeService.add(employee))
        {
            return employee.toString();
        }
        return "Error!!";
    }

    @GetMapping("/Employees")
    public String GetEmployees()
    {
        return employeeService.getAll();
    }

    @GetMapping("/hello/{name}")
    public String Hello(@PathVariable String name)
    {
        return "Hello  "+ name;
    }
}
