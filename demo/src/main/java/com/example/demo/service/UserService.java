package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.User;

@Component
public class UserService {
    
    public List<User> getUser() {    
        List<User> list = new ArrayList<>();
        list.add(new User("1", "Miaomiao", "miaoXX@gamil.com"));
        list.add(new User("1", "WangWang", "WangWang@gamil.com"));
        list.add(new User("1", "PiPi", "PiPi@gamil.com"));
        list.add(new User("1", "XIXI", "sxc@gamil.com"));
        list.add(new User("1", "XIXI", "sxc@gamil.com"));
        return list;

    }
}