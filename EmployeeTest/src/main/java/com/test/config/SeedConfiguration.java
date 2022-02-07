package com.test.config;

import com.test.model.*;
import com.test.request.CreateEmployeeRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SeedConfiguration {

    @Bean
    public List<Employee> employees() {
        return generateData();
    }

    private List<Employee> generateData() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employees.add(Employee.create(new CreateEmployeeRequest(EmployeeType.HOURLY)));
            employees.add(Employee.create(new CreateEmployeeRequest(EmployeeType.MANAGER)));
            employees.add(Employee.create(new CreateEmployeeRequest(EmployeeType.SALARIED)));
        }
        return employees;
    }

}
