package com.exalt.usecase.service;

import com.exalt.usecase.dto.RoleDto;
import com.exalt.usecase.dto.UserProfileDto;
import com.exalt.usecase.dto.mapper.RoleMapper;
import com.exalt.usecase.model.Role;
import com.exalt.usecase.model.UserProfile;
import com.exalt.usecase.repositoris.RoleRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    private RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);

    @Override
    public void create(RoleDto roleDto) {
        roleRepository.save(roleMapper.dtoToRole(roleDto));
    }

    @Override
    public Page<RoleDto> getPage(int page, int limit) {
        Page<Role> roles = roleRepository.findAll(PageRequest.of(page, limit));
        Page<RoleDto> roleDtos = roles.map(role -> roleMapper.roleToDto(role) );
        return roleDtos;
    }

    @Override
    public RoleDto getById(int id) {
        return roleMapper.roleToDto(roleRepository.findById(id));
    }

    @Override
    public List<RoleDto> getAll()
    {
        return roleMapper.roleToDto(roleRepository.findAll());
    }

    @Override
    public void deletById(int id) {
        roleRepository.deleteByIdNQ(id);
    }

    @Override
    public void update(int id, RoleDto roleDto) {
        if(roleRepository.findById(id) != null ){
            Role role = roleRepository.findById(id);
            role = roleMapper.merge(roleDto,role);
            roleRepository.save(role);
        }
    }
}
