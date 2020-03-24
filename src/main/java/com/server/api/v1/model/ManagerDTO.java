package com.server.api.v1.model;

import com.server.domain.Employee;
import com.server.domain.Project;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Long salary;
    private Set<Project> projects =  new HashSet<>();
    private Set<Employee> employees = new HashSet<>();

}
