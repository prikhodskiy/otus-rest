package org.aprikhodskiy.otus.employeesvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aprikhodskiy.otus.employeesvc.repository.EmployeeRepository;
import org.aprikhodskiy.otus.employeesvc.domain.Employee;
import org.aprikhodskiy.otus.employeesvc.dto.DepartmentDTO;
import org.aprikhodskiy.otus.employeesvc.dto.EmployeeDTO;
import org.aprikhodskiy.otus.employeesvc.dto.EmployeeDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceRest implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream().map(EmployeeDTO::fromEmployee).collect(Collectors.toList());
    }

    @Override
    public EmployeeDetailDTO findById(Long id) {
        log.info("Request for employee {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        DepartmentDTO department = departmentService.findById(employee.getDepartmentId());

        return EmployeeDetailDTO.fromEmployee(employee, department.getName());
    }
}
