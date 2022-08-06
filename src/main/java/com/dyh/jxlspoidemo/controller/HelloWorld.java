package com.dyh.jxlspoidemo.controller;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorld {

    @GetMapping()
    public String  helloWorld(){
        return "HelloWorld!";
    }

    @PostMapping
    public void export(){

    }



}
