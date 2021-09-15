package org.aprikhodskiy.otus.employeesvc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.aprikhodskiy.otus.employeesvc.domain.Employee;

@Getter
@Setter
@Builder
public class EmployeeDetailDTO {
    private Long id;
    private String name;
    private String department;

    public static EmployeeDetailDTO fromEmployee(Employee employee, String department) {
        return EmployeeDetailDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .department(department)
                .build();
    }
}

