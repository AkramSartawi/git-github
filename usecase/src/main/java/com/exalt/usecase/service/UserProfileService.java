package com.exalt.usecase.service;

import com.exalt.usecase.dto.UserProfileDto;
import org.springframework.data.domain.Page;
import java.util.List;

public interface UserProfileService {
    void create(UserProfileDto user, int userid );

    Page<UserProfileDto> getPage(int page, int limit );

    UserProfileDto getById(int id );

    void deletById(int id);

    List<UserProfileDto> getAll();

    void ubdate(int id , UserProfileDto userProfileDto);
}
