package com.server.services;

import com.server.api.v1.model.ManagerDTO;

import java.util.List;

public interface ManagerService {

    List<ManagerDTO> getAllManagers();

    ManagerDTO findByLastName(String lastName);

}
