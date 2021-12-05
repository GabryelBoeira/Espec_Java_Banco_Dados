package com.br.espec.utfpr.simuladoProva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimuladoProvaApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SimuladoProvaApplication.class);

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {

		SpringApplication.run(SimuladoProvaApplication.class, args);
	}

	@Bean
	public CommandLineRunner AtividadeApplicationTeste() {

		return (arg) -> {
			LOG.info("============================================================");
			LOG.info("=             Simulado prova banco de dados                =");
			LOG.info("============================================================");

			SpringApplication.exit(appContext, () -> 0);
		};
	}

}
