package com.evfjunior.contactmanager.configuration;

import com.evfjunior.contactmanager.util.ViewName;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewName.MAIN);
        registry.addViewController("/main").setViewName(ViewName.MAIN);
    }
}
