package com.exalt.usecase.controller;

import com.exalt.usecase.dto.UserCreateDto;
import com.exalt.usecase.dto.UserDto;
import com.exalt.usecase.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
   // @Qualifier("x")
    private UserService userService;

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/page")
    public Page<UserDto> getUsersPaging(@RequestParam(name = "page") int page,
                                           @RequestParam(name = "limit") int limit) {
        logger.info("add getUsers method is acessed ");
        return (userService.getUsers(page, limit));
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/all")
    public  List<UserDto> getAllUsers() {
        logger.info("add getUsers method is acessed ");
        return (userService.getUsers());
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public UserDto getUserById(@PathVariable int id ) {
        logger.trace("get user by id  method is accessed");
        return userService.getUserById(id);
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public UserDto adduUser(@RequestBody UserCreateDto user) {
        logger.info("add USERS method is acessed ");
        return userService.createUser(user);
    }

    /**
     *
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        logger.info("Delete USERS method is acessed ");
         userService.deletUserById(id);
    }

    /**
     *
     * @param userCreateDto
     * @param id
     */
    @RequestMapping(method = RequestMethod.PUT ,value = "/users/{id}")
    public void update(@RequestBody UserCreateDto userCreateDto,@PathVariable int id){
        logger.info("update USERS method is acessed ");
        userService.ubdateUser(id , userCreateDto);
    }

    /**
     *
     * @param userId
     * @param roleId
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/assign/{userId}/{roleId}")
    public void assignRole(@PathVariable int userId , @PathVariable int roleId) {
        logger.info("assignRole method is acessed ");
        userService.assignUSerToRole(userId,roleId);
    }

    /**
     *
     * @param userId
     * @param roleId
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/user/{userId}/role/{roleId}/assign")
    public void assignUserToRole(@PathVariable int userId , @PathVariable int roleId) {
        logger.info("assignRole method is accessed {}", userId);
        userService.assignUserToRole(userId,roleId);
    }
}
