package com.example.demo.rest;

import com.example.demo.entity.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
@Api(description = "swagger")
public class SwaggerRest {
    
    //http://localhost:8081/swagger-ui.html#/

    @ApiOperation(value = "create user", notes = "")
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String createUser(User user) {
        return "User is : " + user.toString();
    }

    @ApiOperation(value = "input form", notes = "")
    @RequestMapping(value = {"/input"}, method = RequestMethod.POST)
    public String input(@RequestParam Long id, @RequestParam String day, @RequestParam String count) {
        return "day " + day + " count" + count;
    }
}