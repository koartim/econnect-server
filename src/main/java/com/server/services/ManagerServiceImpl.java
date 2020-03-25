package com.server.services;

import com.server.api.v1.mapper.ManagerMapper;
import com.server.api.v1.model.ManagerDTO;
import com.server.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerMapper managerMapper, ManagerRepository managerRepository) {
        this.managerMapper = managerMapper;
        this.managerRepository = managerRepository;
    }

    @Override
    public List<ManagerDTO> getAllManagers() {
        return managerRepository.findAll()
                .stream()
                .map(manager -> managerMapper.managerToManagerDTO(manager))
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDTO findByLastName(String lastName) {
        return managerMapper.managerToManagerDTO(managerRepository.findByLastName(lastName));
    }
}
