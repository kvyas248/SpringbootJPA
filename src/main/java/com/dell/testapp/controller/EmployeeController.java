package com.dell.testapp.controller;

import com.dell.testapp.entities.Employee;
import com.dell.testapp.service.EmployeeService;
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

    @GetMapping("/employees")
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
