package com.test.repo;

import com.test.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepo {
    private final List<Employee> employees;

    @Autowired
    public EmployeeRepo(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> getById(String id) {
        return employees.stream().filter(e -> e.getEmployeeId().equals(id)).findFirst();
    }

    public Employee save(Employee employee) {
        if (getById(employee.getEmployeeId()).isPresent()) {
            throw new RuntimeException("Employee with id : " + employee.getEmployeeId() + " already exists");
        }
        employees.add(employee);
        return employee;
    }
}
