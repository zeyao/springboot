package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.User;

@Component
public class UserService {
    
    public List<String> getUser() {    
        List<String> list = new ArrayList<>();
        list.add(new User("1", "Miaomiao", "miaoXX@gamil.com").toString());
        list.add(new User("1", "WangWang", "WangWang@gamil.com").toString());
        list.add(new User("1", "PiPi", "PiPi@gamil.com").toString());
        list.add(new User("1", "XIXI", "sxc@gamil.com").toString());
        return list;

    }
}