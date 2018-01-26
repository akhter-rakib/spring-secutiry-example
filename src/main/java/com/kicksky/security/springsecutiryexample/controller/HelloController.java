package com.kicksky.security.springsecutiryexample.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
//@RequestMapping("/rest/hello")
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello() {
        //way to see the loginUser
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        return "Hello Bangladesh How are You ";
    }

    @RequestMapping(value = "/callMe", method = RequestMethod.GET)
    public String callMe(@AuthenticationPrincipal final UserDetails userDetails) {
        //another way to see login user
        String userName = userDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities.forEach(System.out::println);
        return "Call me Please";
    }
}
