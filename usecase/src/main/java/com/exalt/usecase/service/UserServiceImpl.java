package com.exalt.usecase.service;

import com.exalt.usecase.dto.UserCreateDto;
import com.exalt.usecase.dto.UserDto;
import com.exalt.usecase.dto.mapper.UserMapper;
import com.exalt.usecase.exception.EnumError;
import com.exalt.usecase.exception.GeneralException;
import com.exalt.usecase.exception.PassowrdException;
import com.exalt.usecase.model.Role;
import com.exalt.usecase.model.User;
import com.exalt.usecase.repositoris.RoleRepository;
import com.exalt.usecase.repositoris.UserReposetory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReposetory userRepository;

    @Autowired
    private RoleRepository roleRepository;

   // @Autowired
   // private PassowrdEncoder passowrdEncoder;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    public UserDto createUser(UserCreateDto user) {
        if (user.getPassword().length() != 10) {
            throw new PassowrdException("Password should be 10 digit");
        }
        if (userRepository.findEmailExistNQ(user.getEmail()) != 0) {
            throw new GeneralException(EnumError.EXIST_EMAIL);
        }
        return userMapper.mapUserDtoToDTO(userRepository.save(userMapper.dtoTOUser(user)));
    }

    @Override
    public Page<UserDto> getUsers(int page, int limit) {
        Page<User> users = userRepository.findAll(PageRequest.of(page, limit));
       // Page<User> users = userRepository.findAllNQ1(((page - 1) * limit), limit);
        Page<UserDto> userDtos = users.map(user -> userMapper.mapUserDtoToDTO(user));
        return userDtos;
    }

    @Override
    public List<UserDto> findUsersPagging(int page, int limit) {
        return userMapper.mapUserDtoToDTO(userRepository.findAllNQ(((page - 1) * limit), limit));
    }

    @Override
    public UserDto getUserById(int id) {
        return userMapper.mapUserDtoToDTO(userRepository.getAllusersById(id));
    }

    @Override
    public void deletUserById(int id) {
        userRepository.deleteByIdNQ(id);
    }

    @Override
    public List<UserDto> getUsers() {
        return userMapper.mapUserDtoToDTO(userRepository.findAll());
    }

    @Override
    public void ubdateUser(int id, UserCreateDto userCreateDto) {
        User user = userRepository.findById(id).get();
        System.out.println(user);
        user = userMapper.merge(userCreateDto, user);
        userRepository.save(user);
    }

    @Override
    public void assignUSerToRole(int userId, int roleId) {
        userRepository.assignUserToRoleNQ(userId, roleId);
    }

    @Override
    public void assignUserToRole(int userId, int roleId) {
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId);
        if (user != null & role != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }
}
