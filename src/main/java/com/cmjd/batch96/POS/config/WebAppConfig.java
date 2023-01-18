package com.cmjd.batch96.POS.config;


import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppConfig {

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
