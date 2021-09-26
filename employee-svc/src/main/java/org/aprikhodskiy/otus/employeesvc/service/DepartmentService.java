package org.aprikhodskiy.otus.employeesvc.service;

import org.aprikhodskiy.otus.employeesvc.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO findById(long id);
}
