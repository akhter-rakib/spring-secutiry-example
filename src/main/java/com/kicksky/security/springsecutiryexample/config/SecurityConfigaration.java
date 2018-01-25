package com.kicksky.security.springsecutiryexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration //works when springboot app start the loading configaration by this anotation
public class SecurityConfigaration extends WebSecurityConfigurerAdapter {
    //WebSecurityConfigurerAdapter contains all springSecuroty related injection

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("rakib").password("test").roles("ADMIN").and()
                .withUser("hasan").password("test").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                // .antMatchers("**//rest/*")
                .anyRequest().fullyAuthenticated()
                .and().httpBasic();
        httpSecurity.csrf().disable();

    }
}