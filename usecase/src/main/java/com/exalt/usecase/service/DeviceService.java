package com.exalt.usecase.service;

import com.exalt.usecase.dto.DeviceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeviceService {
    void create(DeviceDto deviceDto );

    Page<DeviceDto> getPage(int page , int limit );

    DeviceDto getById(int id );

    void deletById(int id);

    List<DeviceDto> getAll();

    void update(int id , DeviceDto deviceDto);
}
