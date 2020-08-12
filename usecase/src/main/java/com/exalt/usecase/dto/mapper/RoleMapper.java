package com.exalt.usecase.dto.mapper;

import com.exalt.usecase.dto.RoleDto;
import com.exalt.usecase.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper
public interface RoleMapper {
    List<RoleDto> roleToDto(List<Role> roles);

    RoleDto roleToDto(Role role);

    Role dtoToRole(RoleDto roleDto);

    Role merge(RoleDto roleDto, @MappingTarget Role target);
}
