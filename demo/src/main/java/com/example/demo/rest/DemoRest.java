package com.example.demo.rest;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.example.demo.entity.User;
import com.example.demo.service.CodingQuestionService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DemoRest {

    @Autowired
    private CodingQuestionService codingQuestionService;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;
    
    @RequestMapping("/helloSpringBoot")
    public String helloSpringBoot() {
        return "Hello Spring Boot - this is a demo rest service";
    }

    @RequestMapping("/findcombination/{k}/{n}")
    public String test(@PathVariable int k, @PathVariable int n) {
        StringBuilder sb = new StringBuilder();
        codingQuestionService.combinationSum(k, n).forEach(list -> {
            sb.append("[");
            list.forEach(sb::append);
            sb.append("]");
        });

        return sb.toString();
    }

    @RequestMapping("/getAllUser")
    public String getAllUser() {
        try {
            StringBuilder sb = new StringBuilder();
            userService.getUser().forEach(a -> sb.append(a.toString()));
            return objectMapper.writeValueAsString(sb.toString()); 
        } catch (IOException e) {
            return "Error when parsing Json";
        }
    }


    @RequestMapping("/getAllUserCountByName")
    public String getAllUserCountByName() {
        try {
            String targetName = "XIXI";
            List<User> user = userService.getUser();
            int count = sum(user, u -> targetName.equals(u.getUserName()));
            return String.valueOf(count); 
        } catch (Exception e) {
            return "Error when parsing Json";
        }
    }

    @RequestMapping("/getAllUserCountByEmail")
    public String getAllUserCountByEmail() {
        try {
            String email = "PiPi@gamil.com";
            List<User> user = userService.getUser();
            int count = sum(user, u -> email.equals(u.getEmail()));
            return String.valueOf(count);
        } catch (Exception e) {
            return "Error when parsing Json";
        }
    }
    //Predicate 函数接口设计模式
    //用于定义common behavior
    //如果我们要对某个对象进行很多不同的判断
    //减少类似的代码的重复使用
    public int sum(List<User> list, Predicate<User> p) {
        int res = 0;
        for (User i : list) {
            if (p.test(i)) {
                res++;
            }
        }
        return res;
    }



}