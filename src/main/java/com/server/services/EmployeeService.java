package com.server.services;

import com.server.api.v1.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO findByLastName(String lastName);

}
