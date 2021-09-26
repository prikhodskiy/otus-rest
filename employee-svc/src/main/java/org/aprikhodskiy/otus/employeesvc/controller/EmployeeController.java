package org.aprikhodskiy.otus.employeesvc.controller;

import lombok.RequiredArgsConstructor;
import org.aprikhodskiy.otus.employeesvc.dto.EmployeeDTO;
import org.aprikhodskiy.otus.employeesvc.dto.EmployeeDetailDTO;
import org.aprikhodskiy.otus.employeesvc.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDTO> all() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDetailDTO findById(@PathVariable(name = "id") long id){
        return employeeService.findById(id);
    }
}
