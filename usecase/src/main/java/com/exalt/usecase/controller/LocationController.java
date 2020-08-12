package com.exalt.usecase.controller;

import com.exalt.usecase.dto.LocationDto;
import com.exalt.usecase.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class LocationController {
    private final static Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService service;

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/location/page")
    public Page<LocationDto> getPaging(@RequestParam(name = "page", defaultValue = "1") int page,
                                       @RequestParam(name = "limit") int limit) {
        logger.info("add getUsers method is acessed ");
        return (service.getPage(page, limit));
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/location/all")
    public  List<LocationDto> getAll() {
        logger.info("getAll method is acessed ");
        return (service.getAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/location/{id}")
    public LocationDto getById(@PathVariable int id ) {
        logger.trace("getById method is accessed");
        return service.getById(id);
    }

    /**
     *
     * @param locationDto
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/location")
    public void add(@RequestBody LocationDto locationDto) {
        logger.info("add method is acessed ");
        service.create(locationDto);
    }

    /**
     *
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/location/{id}")
    public void deleteById(@PathVariable int id) {
        logger.info("deleteById method is acessed ");
        service.deletById(id);
    }

    /**
     *
     * @param locationDto
     * @param id
     */
    @RequestMapping(method = RequestMethod.PUT ,value = "/users/location/{id}")
    public void update(@RequestBody LocationDto locationDto,@PathVariable int id){
        logger.info("update  method is acessed ");
        service.update(id , locationDto);
    }
}
