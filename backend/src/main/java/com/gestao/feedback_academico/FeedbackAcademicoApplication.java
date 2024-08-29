package com.gestao.feedback_academico;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class FeedbackAcademicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackAcademicoApplication.class, args);
	}

	// isso tem que esta em uma classe de configurção de aplicação
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}