package org.aprikhodskiy.otus.departmentsvc.service;

import org.aprikhodskiy.otus.departmentsvc.domain.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceRest implements DepartmentService {

    private List<Department> departments = generateDepartments();

    private List<Department> generateDepartments() {
        List<Department> departmentsList = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            departmentsList.add(Department.builder().id(i).name("Department " + i).build());        }
        return departmentsList;
    }

    @Override
    public Department findDepartment(long id) {
        return departments.stream().filter(d -> d.getId() == id).findFirst()
                .orElseThrow(()->new RuntimeException("Department not found"));
    }
}
