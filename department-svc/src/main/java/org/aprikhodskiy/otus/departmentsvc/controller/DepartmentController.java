package org.aprikhodskiy.otus.departmentsvc.controller;

import lombok.RequiredArgsConstructor;
import org.aprikhodskiy.otus.departmentsvc.domain.Department;
import org.aprikhodskiy.otus.departmentsvc.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/departments/{id}")
    public Department findById(@PathVariable(name = "id") Long id) {
        return departmentService.findDepartment(id);
    }
}
