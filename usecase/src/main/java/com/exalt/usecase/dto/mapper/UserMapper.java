package com.exalt.usecase.dto.mapper;

import com.exalt.usecase.dto.UserCreateDto;
import com.exalt.usecase.dto.UserDto;
import com.exalt.usecase.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UserDto> mapUserDtoToDTO(List<User> users);

    UserDto mapUserDtoToDTO(User user);

    @Mapping(target = "id" ,ignore = true)
    User dtoTOUser(UserCreateDto userCreateDto);

    @Mapping(target = "id" ,ignore = true)
    User merge(UserCreateDto userCreateDto, @MappingTarget User target);
}
