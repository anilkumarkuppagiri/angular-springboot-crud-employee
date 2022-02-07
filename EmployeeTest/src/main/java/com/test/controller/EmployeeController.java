package com.test.controller;

import com.test.model.Employee;
import com.test.request.CreateEmployeeRequest;
import com.test.request.VacationRequest;
import com.test.request.WorkRequest;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id) {
        return employeeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Validated CreateEmployeeRequest request) {
        return employeeService.create(request);
    }

    @PutMapping("/vacation/{id}")
    public Employee vacationRequest(@PathVariable String id, @Validated @RequestBody VacationRequest vacationRequest) {
        return employeeService.vacationRequest(id, vacationRequest.getRequestedDays());
    }

    @PutMapping("/work/{id}")
    public Employee workingDays(@PathVariable String id, @Validated @RequestBody WorkRequest workRequest) {
        return employeeService.workRequest(id, workRequest.getWorkingDays());
    }
}
