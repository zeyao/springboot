package com.example.demo.rest;

import com.example.demo.service.CodingQuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRest {

    @Autowired
    private CodingQuestionService codingQuestionService;
    
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


}