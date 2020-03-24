package com.server.api.v1.model;

import com.server.domain.Manager;
import com.server.domain.Project;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Long salary;
    private Project project;
    private Manager manager;


}
