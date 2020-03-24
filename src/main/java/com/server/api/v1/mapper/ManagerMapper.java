package com.server.api.v1.mapper;

import com.server.api.v1.model.ManagerDTO;
import com.server.domain.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    ManagerDTO managerToManagerDTO(Manager manager);

}
