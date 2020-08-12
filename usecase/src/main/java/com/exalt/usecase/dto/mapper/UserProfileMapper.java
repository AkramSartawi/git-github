package com.exalt.usecase.dto.mapper;

import com.exalt.usecase.dto.UserProfileDto;
import com.exalt.usecase.model.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper
public interface UserProfileMapper {
    List<UserProfileDto> userToDto(List<UserProfile> users);

    UserProfileDto userToDto(UserProfile user);

    UserProfile dtoTOUserProfile(UserProfileDto userProfileDto);

    UserProfile merge(UserProfileDto userProfileDto, @MappingTarget UserProfile target);
}
