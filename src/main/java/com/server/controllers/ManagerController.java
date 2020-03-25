package com.server.controllers;

import com.server.api.v1.model.ManagerListDTO;
import com.server.services.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/managers")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public ResponseEntity<ManagerListDTO> getManagers() {
        return new ResponseEntity<ManagerListDTO>(new ManagerListDTO(managerService.getAllManagers()),
                HttpStatus.OK);
    }

}
