package com.kicksky.security.springsecutiryexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/rest/hello")
public class HelloController {
    @GetMapping(value = "/rest/hello")
    public String hello() {
        return "Hello Bangladesh How are You ";
    }

    @RequestMapping(value = "/callMe", method = RequestMethod.GET)
    public String callMe() {
        return "Call me Please";
    }
}
