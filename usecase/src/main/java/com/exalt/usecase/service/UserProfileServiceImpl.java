package com.exalt.usecase.service;

import com.exalt.usecase.dto.UserProfileDto;
import com.exalt.usecase.dto.mapper.UserProfileMapper;
import com.exalt.usecase.exception.EnumError;
import com.exalt.usecase.exception.GeneralException;
import com.exalt.usecase.model.User;
import com.exalt.usecase.model.UserProfile;
import com.exalt.usecase.repositoris.UserProfileRepository;
import com.exalt.usecase.repositoris.UserReposetory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserReposetory userReposetory;

    private UserProfileMapper userProfileMapper = Mappers.getMapper(UserProfileMapper.class);

    @Override
    public void create(UserProfileDto userProfileDto , int userid) {
        User user = userReposetory.getAllusersById(userid);
        if(user == null ){
            throw new GeneralException(EnumError.USEER_NOT_FOUND);
        }
        UserProfile userProfile = userProfileMapper.dtoTOUserProfile(userProfileDto);
        userProfile.setId(userid);
        userProfile.setUser(user);
        userProfileRepository.save(userProfile);
    }

    @Override
    public Page<UserProfileDto> getPage(int page, int limit) {
        Page<UserProfile> userProfiles = userProfileRepository.findAll(PageRequest.of(page, limit));
        Page<UserProfileDto> userProfileDtos = userProfiles.map(userProfile -> userProfileMapper.userToDto(userProfile) );
        return userProfileDtos;
    }

    @Override
    public UserProfileDto getById(int id) {
        return userProfileMapper.userToDto(userProfileRepository.findById(id));
    }

    @Override
    public List<UserProfileDto> getAll() {
        return userProfileMapper.userToDto(userProfileRepository.findAll());
       }

    @Override
    public void deletById(int id) {
        userProfileRepository.deleteByIdNQ(id);
    }

    @Override
    public void ubdate(int id, UserProfileDto userProfileDto) {
        if(userProfileRepository.findById(id)!=null ){
            UserProfile userProfile = userProfileRepository.findById(id);
            userProfile = userProfileMapper.merge(userProfileDto,userProfile);
            userProfileRepository.save(userProfile);
        }
    }
}
