package com.server.controllers;

import com.server.api.v1.model.EmployeeListDTO;
import com.server.domain.Employee;
import com.server.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
   public ResponseEntity<EmployeeListDTO> getEmployees() {
        return new ResponseEntity<EmployeeListDTO>(new EmployeeListDTO(employeeService.getAllEmployees()),
                HttpStatus.OK);
    }

}
