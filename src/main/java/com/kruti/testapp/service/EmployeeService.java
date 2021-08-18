package com.kruti.testapp.service;

import com.kruti.testapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    @Qualifier("writeJdbcTemplate")
    private JdbcTemplate writeTemplate;

    @Autowired
    @Qualifier("readJdbcTemplate")
    private JdbcTemplate readTemplate;

    private final String INSERT_SQL = "INSERT INTO employee(id,name,email) values(?,?,?)";
    private final String SELECT_ALL = "SELECT * FROM employee";

    public boolean add(Employee employee)
    {
        try {
            writeTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, employee.getId());
                    ps.setString(2, employee.getName());
                    ps.setString(3, employee.getEmail());
                    return ps;
                }
            });
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getAll()
    {
        String query = " select * from employee";
        List<Employee> employees = readTemplate.query(
                SELECT_ALL,
                new EmployeeRowMapper());
        
        String response = "";
        for (Employee e :
                employees) {
            response+= " "+e.toString();
        }
        return response;
    }
}
