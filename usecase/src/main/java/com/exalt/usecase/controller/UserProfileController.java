package com.exalt.usecase.controller;

import com.exalt.usecase.dto.UserProfileDto;
import com.exalt.usecase.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserProfileController {
    private final static Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    @Autowired
    private UserProfileService service;

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/profile/page")
    public Page<UserProfileDto> getPaging(@RequestParam(name = "page") int page,
                                          @RequestParam(name = "limit") int limit) {
        logger.info("add getUsers method is abscessed with page{} and limit {}",page,limit);
        return (service.getPage(page, limit));
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/profile/all")
    public  List<UserProfileDto> getAll() {
        logger.info("getAll method ");
        return (service.getAll());
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/profile/{id}")
    public UserProfileDto getById(@PathVariable int id ) {
        logger.trace("getById method is accessed");
        return service.getById(id);
    }

    /**
     *
     * @param userProfileDto
     * @param user_id
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/{user_id}/profile")
    public void add(@RequestBody UserProfileDto userProfileDto , @PathVariable int user_id) {
        logger.info("add method is accessed ");
        service.create(userProfileDto, user_id);
    }

    /**
     *
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/profile/{id}")
    public void deleteById(@PathVariable int id) {
        logger.info("deleteById method is accessed ");
        service.deletById(id);
    }

    /**
     *
     * @param userProfileDto
     * @param id
     */
    @RequestMapping(method = RequestMethod.PUT ,value = "/users/profile/{id}")
    public void update(@RequestBody UserProfileDto userProfileDto,@PathVariable int id){
        logger.info("update  method is accessed ");
        service.ubdate(id , userProfileDto);
    }
}
