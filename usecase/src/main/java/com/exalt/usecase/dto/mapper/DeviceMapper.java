package com.exalt.usecase.dto.mapper;

import com.exalt.usecase.dto.DeviceDto;
import com.exalt.usecase.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper
public interface DeviceMapper {
    List<DeviceDto> deviceToDto(List<Device> devices);

    DeviceDto deviceToDto(Device device);

    @Mapping(target = "locations", ignore = true)
    @Mapping(target = "id" ,ignore = true)
    Device dtoToDevice(DeviceDto deviceDto);

    Device merge(DeviceDto deviceDto, @MappingTarget Device target);
}
