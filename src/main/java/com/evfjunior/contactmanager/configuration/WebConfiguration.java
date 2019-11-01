package com.evfjunior.contactmanager.configuration;

import com.evfjunior.contactmanager.util.ViewName;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    // Heroku PostgreSQL Connection
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewName.MAIN);
        registry.addViewController("/details").setViewName(ViewName.DETAILS);
        registry.addViewController("/edit").setViewName(ViewName.EDIT);
        registry.addViewController("/main").setViewName(ViewName.MAIN);
        registry.addViewController("/new").setViewName(ViewName.NEW);
    }
}
