package com.exalt.usecase.controller;

import com.exalt.usecase.dto.RoleDto;
import com.exalt.usecase.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RoleController {
    private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService service;

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/role/page")
    public Page<RoleDto> getPaging(@RequestParam(name = "page") int page,
                                   @RequestParam(name = "limit") int limit) {
        logger.info("add getUsers method is acessed ");
        return (service.getPage(page, limit));
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/role/all")
    public  List<RoleDto> getAll() {
        logger.info("getAll method is acessed ");
        return (service.getAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/role/{id}")
    public RoleDto getById(@PathVariable int id ) {
        logger.trace("getById method is accessed");
        return service.getById(id);
    }

    /**
     *
     * @param roleDto
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/role")
    public void add(@RequestBody RoleDto roleDto) {
        logger.info("add method is acessed ");
        service.create(roleDto);
    }

    /**
     *
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/role/{id}")
    public void deleteById(@PathVariable int id) {
        logger.info("deleteById method is acessed ");
        service.deletById(id);
    }

    /**
     *
     * @param roleDto
     * @param id
     */
    @RequestMapping(method = RequestMethod.PUT ,value = "/users/role/{id}")
    public void update(@RequestBody RoleDto roleDto,@PathVariable int id){
        logger.info("update  method is acessed ");
        service.update(id , roleDto);
        logger.info("update  method is Finished ");
    }
}
