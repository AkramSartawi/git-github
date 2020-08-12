package com.exalt.usecase.service;

import com.exalt.usecase.dto.LocationDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LocationService {
    void create(LocationDto locationDto );

    Page<LocationDto> getPage(int page , int limit );

    LocationDto getById(int id );

    void deletById(int id);

    List<LocationDto> getAll();

    void update(int id , LocationDto locationDto);
}
