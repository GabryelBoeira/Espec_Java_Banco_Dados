package com.br.espec.provaDB;

import com.br.espec.provaDB.model.Cargo;
import com.br.espec.provaDB.repository.CargoRepository;
import com.br.espec.provaDB.repository.FuncionarioRepository;
import com.br.espec.provaDB.service.CargoService;
import com.br.espec.provaDB.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProvaDBApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ProvaDBApplication.class);

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {

		SpringApplication.run(ProvaDBApplication.class, args);
	}

	@Bean
	public CommandLineRunner AtividadeApplicationTeste(CargoService cargoService,
														 FuncionarioService funcionarioService, CargoRepository cargoRepository,
														 FuncionarioRepository funcionarioRepository) {

		starData(cargoRepository, funcionarioRepository);
		return (arg) -> {
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Prova de Banco de dados ");
			LOG.info("---------------------------------------------------------------------------");



			SpringApplication.exit(appContext, () -> 0);
		};
	}
	
	public void starData(CargoRepository cargoRepository,
						 FuncionarioRepository funcionarioRepository) {
		
		funcionarioRepository.deleteAll();
		cargoRepository.deleteAll();

		Cargo cargo1 = cargoRepository.save(new Cargo("Recursos Humanos"));
		Cargo cargo2 = cargoRepository.save(new Cargo("Contabilidade"));
		Cargo cargo3 = cargoRepository.save(new Cargo("Vendas"));
		Cargo cargo4 = cargoRepository.save(new Cargo("Compras"));
		Cargo cargo5 = cargoRepository.save(new Cargo("Suporte ao Cliente"));
		/*
		funcionarioRepository.save(new Funcionario("152215", "Jose da Silva", "Gerente de RH",  2, 3700D, dep1));
		funcionarioRepository.save(new Funcionario("255544", "Andre da Silva","Assistente de RH", 1, 1700D, dep1));
		funcionarioRepository.save(new Funcionario("352153", "João da Silva","Estagiario(a) de RH", 0, 600D, dep1));
		funcionarioRepository.save(new Funcionario("412323", "Roberta da Silva", "Gerente de Contabilidade", 2, 5500D, dep2));
		funcionarioRepository.save(new Funcionario("534344", "Fernando da Silva", "Contador Pleno", 1, 3600D, dep2));
		funcionarioRepository.save(new Funcionario("655525", "Mariana da Silva","Gerente de Vendas", 0, 3000D, dep3));
		funcionarioRepository.save(new Funcionario("745525", "Manuela da Silva", "Assistente de Vendas", 0, 2300D, dep3));
		funcionarioRepository.save(new Funcionario("825485", "Mario da Silva", "Gerente de Compras", 0, 4300D, dep4));
		funcionarioRepository.save(new Funcionario("932565", "Marcos da Silva", "Assistente de Compras", 1, 1700D, dep4));
		funcionarioRepository.save(new Funcionario("108595", "Manuel da Silva", "Gerente de suporte", 0, 3900D, dep5));
		funcionarioRepository.save(new Funcionario("115855", "Carlos da Silva", "Suporte nivel I", 3, 1700D, dep5));
		funcionarioRepository.save(new Funcionario("122541", "Rafaela da Silva", "Suporte nivel III", 1, 2900D, dep5));
		funcionarioRepository.save(new Funcionario("135241", "Rafael da Silva", "Suporte nivel II", 1, 2200D, dep5));
		 */
	} 
}
