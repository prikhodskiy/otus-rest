package org.aprikhodskiy.otus.employeesvc.repository;

import org.aprikhodskiy.otus.employeesvc.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class EmployeeRepositoryRandom implements EmployeeRepository {
    private Random random = new Random();
    List<Employee> employees = generateEmployees(50);
    private List<Employee> generateEmployees(int count) {
        List<Employee> employeeList = new ArrayList<>();


        int low = 1;
        int high = 10;

        for (long i = 1; i <= count; i++) {
            Long depId = (long) random.nextInt(high - low) + low;
            employeeList.add(Employee.builder()
                    .id(i)
                    .name("Employee " + i)
                    .departmentId(depId)
                    .build());
        }
        return employeeList;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employees.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
