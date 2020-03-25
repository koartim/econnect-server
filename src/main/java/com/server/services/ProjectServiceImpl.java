package com.server.services;

import com.server.api.v1.mapper.ProjectMapper;
import com.server.api.v1.model.ProjectDTO;
import com.server.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(project -> projectMapper.projectToProjectDTO(project))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO findByName(String name) {
        return projectMapper.projectToProjectDTO(projectRepository.findByName(name));
    }
}
