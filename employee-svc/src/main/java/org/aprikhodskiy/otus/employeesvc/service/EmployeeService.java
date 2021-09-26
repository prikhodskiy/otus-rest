package org.aprikhodskiy.otus.employeesvc.service;

import org.aprikhodskiy.otus.employeesvc.dto.EmployeeDTO;
import org.aprikhodskiy.otus.employeesvc.dto.EmployeeDetailDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDetailDTO findById(Long id);
}
