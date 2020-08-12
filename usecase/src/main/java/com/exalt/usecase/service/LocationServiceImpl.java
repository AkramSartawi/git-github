package com.exalt.usecase.service;

import com.exalt.usecase.dto.LocationDto;
import com.exalt.usecase.dto.mapper.LocationDeviceMapper;
import com.exalt.usecase.model.Location;
import com.exalt.usecase.repositoris.LocationRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    LocationRepository locationRepository ;

    private LocationDeviceMapper locationDeviceMapper = Mappers.getMapper(LocationDeviceMapper.class);

    @Override
    public void create(LocationDto locationDto) {
        locationRepository.save(locationDeviceMapper.dtoToLocation(locationDto));
    }

    @Override
    public Page<LocationDto> getPage(int page, int limit) {
        Page<Location> userProfiles = locationRepository.findAll(PageRequest.of(page, limit));
        Page<LocationDto>  userProfileDtos = userProfiles.map(location -> locationDeviceMapper.locationToDto(location) );
        return userProfileDtos;
    }

    @Override
    public LocationDto getById(int id) {
        return locationDeviceMapper.locationToDto(locationRepository.findById(id));
    }

    @Override
    public void deletById(int id) {
        locationRepository.deleteByIdNQ(id);
    }

    @Override
    public List<LocationDto> getAll() {
        return locationDeviceMapper.locationToDto(locationRepository.findAll());
    }

    @Override
    public void update(int id, LocationDto locationDto) {
        if (locationRepository.findById(id) != null ){
            Location location = locationRepository.findById(id);
            location = locationDeviceMapper.merge(locationDto,location);
            locationRepository.save(location);
        }
    }
}
