package com.test.model;

import com.test.request.CreateEmployeeRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode(of = "employeeId")
public class Employee {
    private final static int MAX_WORKING_DAYS = 260;

    private final String employeeId;
    private final EmployeeType type;

    private float accumulatedVacationDays = 0f;
    private float availedVacationDays = 0f;

    protected Employee(String employeeId, EmployeeType type, float accumulatedVacationDays) {
        this.employeeId = employeeId;
        this.type = type;
        this.accumulatedVacationDays = accumulatedVacationDays;
    }

    public void worked(int daysWorkedInAYear) {
        validateWorkDays(daysWorkedInAYear);
        int daysOfVacation = MAX_WORKING_DAYS - daysWorkedInAYear;
        reduceAccumulatedVacation(daysOfVacation);
        this.availedVacationDays = daysOfVacation;
    }

    public void takeVacation(float days) {
        float newVacationDays = this.accumulatedVacationDays - days;
        if (newVacationDays < 0.0f) {
            throw new IllegalArgumentException("Cannot take vacation since exceeding allowed vacation days available");
        }
        reduceAccumulatedVacation(days);
        this.availedVacationDays += days;
    }


    private void reduceAccumulatedVacation(float days) {
        float newDays = this.accumulatedVacationDays - days;
        newDays = newDays < 0f? 0 : newDays;
        this.accumulatedVacationDays = newDays;
    }

    private void validateWorkDays(int daysWorkedInAYear) {
        if (daysWorkedInAYear < 0 || daysWorkedInAYear > MAX_WORKING_DAYS) {
            throw new IllegalArgumentException("Invalid working days, Should be between 0 to 260");
        }
    }

    public static Employee create(CreateEmployeeRequest request) {
        return switch (request.getEmployeeType()) {
            case HOURLY -> new HourlyEmployee(UUID.randomUUID().toString(), request.getEmployeeType());
            case SALARIED -> new SalariedEmployee(UUID.randomUUID().toString(), request.getEmployeeType());
            case MANAGER -> new Manager(UUID.randomUUID().toString(), request.getEmployeeType());
        };
    }

    public String toString() {
        return String.format(
                "Employee [Id :%s, Type: %s] has %f days vacation remaining and has availed %f vacation days",
                employeeId, type.name(), accumulatedVacationDays, availedVacationDays
        );
    }
}
