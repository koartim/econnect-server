package com.server.services;

import com.server.api.v1.model.ManagerDTO;
import com.server.api.v1.model.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> getAllProjects();

    ProjectDTO findByName(String name);

}
