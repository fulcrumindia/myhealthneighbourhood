package com.avviotech.labs.mhn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/rooms").setViewName("rooms");
        registry.addViewController("/userrooms").setViewName("userrooms");
        registry.addViewController("/userdevices").setViewName("userdevices");
        registry.addViewController("/403").setViewName("403");
    }

}