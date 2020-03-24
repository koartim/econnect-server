package com.server.api.v1.model;

import com.server.domain.Employee;
import com.server.domain.Manager;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;
    private String name;
    private Long budget;
    private Set<Manager> managers = new HashSet<>();
    private Set<Employee> employees =  new HashSet<>();

}
