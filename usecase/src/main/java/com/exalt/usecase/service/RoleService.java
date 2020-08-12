package com.exalt.usecase.service;

import com.exalt.usecase.dto.RoleDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {
    void create(RoleDto roleDto );

    Page<RoleDto> getPage(int page , int limit );

    RoleDto getById(int id );

    void deletById(int id);

    List<RoleDto> getAll();

    void update(int id , RoleDto roleDto);
}
