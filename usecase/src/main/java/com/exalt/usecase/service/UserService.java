package com.exalt.usecase.service;

import com.exalt.usecase.dto.UserCreateDto;
import com.exalt.usecase.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserDto createUser(UserCreateDto user );

    Page<UserDto> getUsers(int page , int limit );

    List<UserDto> findUsersPagging(int page , int limit );

    UserDto getUserById(int id );

    void deletUserById(int id);

    List<UserDto> getUsers();

    void ubdateUser(int id , UserCreateDto userCreateDto);

    void assignUSerToRole(int userId , int roleId);

    void assignUserToRole(int userId, int roleId);
}
