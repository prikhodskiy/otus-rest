package org.aprikhodskiy.otus.employeesvc.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {
    private Long id;
    private String name;
    private Long departmentId;
}
