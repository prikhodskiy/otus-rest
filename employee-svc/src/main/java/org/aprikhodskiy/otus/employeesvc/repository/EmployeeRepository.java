package org.aprikhodskiy.otus.employeesvc.repository;

import org.aprikhodskiy.otus.employeesvc.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
}
