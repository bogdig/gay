package com.example.gay.controller;

import com.example.gay.properties.GayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GayProperties gayProperties;

//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "251") Integer id) {
        return "id:" + id;
//        return gayProperties.getCupSize();
    }
}


