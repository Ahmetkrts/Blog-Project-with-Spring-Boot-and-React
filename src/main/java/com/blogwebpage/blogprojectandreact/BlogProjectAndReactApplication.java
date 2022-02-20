package com.blogwebpage.blogprojectandreact;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogProjectAndReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogProjectAndReactApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
