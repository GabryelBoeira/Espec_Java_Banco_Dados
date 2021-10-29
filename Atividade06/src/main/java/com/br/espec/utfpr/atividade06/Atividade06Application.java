package com.br.espec.utfpr.atividade06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.br.espec.utfpr.atividade06.service.DepartamentoService;
import com.br.espec.utfpr.atividade06.service.FuncionarioService;

@SpringBootApplication
public class Atividade06Application {

	private static final Logger log = LoggerFactory.getLogger(Atividade06Application.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(Atividade06Application.class, args);
	}

	@Bean
	public CommandLineRunner Atividade06Application(DepartamentoService departamentoService, FuncionarioService funcionarioService) {
		
		return (arg) -> {
			
		};		
	}
}
