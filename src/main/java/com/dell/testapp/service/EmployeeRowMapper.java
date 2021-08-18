package com.dell.testapp.service;

import com.dell.testapp.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee employee = new Employee();
        employee.setId(rs.getInt("ID"));
        employee.setName(rs.getString("NAME"));
        employee.setEmail(rs.getString("EMAIL"));

        return employee;

    }
}
