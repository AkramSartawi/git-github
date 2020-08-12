package com.exalt.usecase.controller;

import com.exalt.usecase.dto.DeviceDto;
import com.exalt.usecase.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DeviceController {
    private final static Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    private DeviceService service;

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/device/page")
    public Page<DeviceDto> getPaging(@RequestParam(name = "page") int page,
                                     @RequestParam(name = "limit") int limit) {
        logger.info("add getUsers method is acessed ");
        return (service.getPage(page, limit));
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/device/all")
    public  List<DeviceDto> getAll() {
        logger.info("getAll method is acessed ");
        return (service.getAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/device/{id}")
    public DeviceDto getById(@PathVariable int id ) {
        logger.trace("getById method is accessed");
        return service.getById(id);
    }

    /**
     *
     * @param deviceDto
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/device")
    public void add(@RequestBody DeviceDto deviceDto) {
        logger.info("add method is acessed ");
        service.create(deviceDto);
    }

    /**
     *
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/device/{id}")
    public void deleteById(@PathVariable int id) {
        logger.info("deleteById method is acessed ");
        service.deletById(id);
    }

    /**
     *
     * @param deviceDto
     * @param id
     */
    @RequestMapping(method = RequestMethod.PUT ,value = "/users/device/{id}")
    public void update(@RequestBody DeviceDto deviceDto,@PathVariable int id){
        logger.info("update  method is acessed ");
        service.update(id , deviceDto);
    }
}
