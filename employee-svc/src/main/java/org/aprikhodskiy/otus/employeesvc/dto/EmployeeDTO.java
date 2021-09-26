package org.aprikhodskiy.otus.employeesvc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.aprikhodskiy.otus.employeesvc.domain.Employee;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EmployeeDTO implements Serializable {
    private long id;
    private String name;

    public static EmployeeDTO fromEmployee(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .build();
    }

}
