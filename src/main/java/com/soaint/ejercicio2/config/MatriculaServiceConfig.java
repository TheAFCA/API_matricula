package com.soaint.ejercicio2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatriculaServiceConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
