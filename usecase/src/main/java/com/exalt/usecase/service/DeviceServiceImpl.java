package com.exalt.usecase.service;

import com.exalt.usecase.dto.DeviceDto;
import com.exalt.usecase.dto.mapper.DeviceMapper;
import com.exalt.usecase.model.Device;
import com.exalt.usecase.repositoris.DeviceRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DeviceServiceImpl implements  DeviceService{
    @Autowired
    DeviceRepository deviceRepository ;

    private DeviceMapper deviceMapper = Mappers.getMapper(DeviceMapper.class);

    @Override
    public void create(DeviceDto deviceDto) {
        deviceRepository.save(deviceMapper.dtoToDevice(deviceDto));
    }

    @Override
    public Page<DeviceDto> getPage(int page, int limit) {
        Page<Device> devices = deviceRepository.findAll(PageRequest.of(page, limit));
        Page<DeviceDto> deviceDtos = devices.map(device -> deviceMapper.deviceToDto(device));
        return deviceDtos;
    }

    @Override
    public DeviceDto getById(int id) {
        return deviceMapper.deviceToDto(deviceRepository.findById(id));
    }

    @Override
    public void deletById(int id) {
        deviceRepository.deleteByIdNQ(id);
    }

    @Override
    public List<DeviceDto> getAll() {
        System.out.println(deviceRepository.findAll());
        return deviceMapper.deviceToDto(deviceRepository.findAll());
    }

    @Override
    public void update(int id, DeviceDto deviceDto) {
        if(deviceRepository.findById(id) != null ){
            Device device = deviceRepository.findById(id);
            device = deviceMapper.merge(deviceDto,device);
            deviceRepository.save(device);
        }
    }
}
