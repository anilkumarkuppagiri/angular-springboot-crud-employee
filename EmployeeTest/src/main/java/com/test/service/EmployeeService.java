package com.test.service;

import com.test.exception.ResourceNotFoundException;
import com.test.model.*;
import com.test.repo.EmployeeRepo;
import com.test.request.CreateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAll() {
        return employeeRepo.getAllEmployees();
    }

    public Employee getById(String id) {
        return employeeRepo.getById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Employee create(CreateEmployeeRequest request) {
        Employee employee = Employee.create(request);
        return employeeRepo.save(employee);
    }

    public Employee vacationRequest(String id, float vacationDays) {
        Employee employee = employeeRepo.getById(id).orElseThrow(ResourceNotFoundException::new);
        employee.takeVacation(vacationDays);
        return employee;
    }

    public Employee workRequest(String id, int workingDays) {
        Employee employee = employeeRepo.getById(id).orElseThrow(ResourceNotFoundException::new);
        employee.worked(workingDays);
        return employee;
    }
}
