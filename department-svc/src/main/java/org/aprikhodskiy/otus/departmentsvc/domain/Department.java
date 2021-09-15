package org.aprikhodskiy.otus.departmentsvc.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Department {
    private long id;
    private String name;
}
