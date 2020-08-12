package com.exalt.usecase.dto.mapper;

import com.exalt.usecase.dto.LocationDto;
import com.exalt.usecase.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper
public interface LocationDeviceMapper {
    List<LocationDto> locationToDto(List<Location> locations);

    LocationDto locationToDto(Location location);

    @Mapping(target = "creationDate",ignore = true)
    Location dtoToLocation(LocationDto locationDto);

    Location merge(LocationDto locationDto, @MappingTarget Location target);
}
