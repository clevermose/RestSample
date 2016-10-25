package com.whs.springboot.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
public class SpringbootSample {
    
    @RequestMapping("/helloword")
    String helloWorld() {
        return "hello world.";
    }
}
