package com.br.espec.provaDB;

import com.br.espec.provaDB.model.Cargo;
import com.br.espec.provaDB.model.Funcionario;
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

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ProvaDbApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ProvaDbApplication.class);

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(ProvaDbApplication.class, args);
	}

	@Bean
	public CommandLineRunner AtividadeApplicationTeste(CargoService cargoService,
													   FuncionarioService funcionarioService, CargoRepository cargoRepository,
													   FuncionarioRepository funcionarioRepository) {

		funcionarioRepository.deleteAll();
		cargoRepository.deleteAll();

		return (arg) -> {
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Prova de Banco de dados ");
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Questão 9: Cadastros");
			LOG.info("----------------------Cargo-----------------------------------------");

			Cargo cargo1 = cargoService.salvarCargo(new Cargo("Gerente Recursos Humanos"));
			Cargo cargo2 = cargoService.salvarCargo(new Cargo("Gerente de Contabilidade"));
			Cargo cargo4 = cargoService.salvarCargo(new Cargo("Contator"));
			cargoService.salvarCargo(new Cargo("Motorista"));
			Cargo cargo3 = cargoService.salvarCargo(new Cargo("Gerente de suporte"));

			funcionarioService.salvarFuncionario(new Funcionario("Jose da Silva", 'M', "(41)99991111", cargo1));
			funcionarioService.salvarFuncionario(new Funcionario("Roberta da Silva", 'F', "(41)99992222", cargo1));
			funcionarioService.salvarFuncionario(new Funcionario("Fernando da Silva", 'M', "(41)99993333", cargo2));
			funcionarioService.salvarFuncionario(new Funcionario("Conrado Ferreira", 'F', "(41)99995555", cargo2));
			funcionarioService.salvarFuncionario(new Funcionario("Maria da Silva", 'F', "(41)99994444", cargo3));
			Funcionario funcionarioDeletar = funcionarioService.salvarFuncionario(new Funcionario("Maria do Rosario ", 'F', "(41)99996666", cargo4));

			for (Cargo cargo : cargoService.listarTodosCargos()) {
				LOG.info("");
				LOG.info("Cargo : " + cargo.toString());
			}
			LOG.info("----------------------Funcionario-----------------------------------------");
			for (Funcionario funcionario : funcionarioService.listarTodosFuncionarios()) {
				LOG.info("");
				LOG.info("Funcionario : " + funcionario.toString());
			}

			LOG.info("---------------------------------------------------------------------------");
			LOG.info("");
			LOG.info("Questão 9: exclusão");
			LOG.info("Excluir pelo menos 1 Cargo pelo identificador");
			LOG.info("Remover Cargo: " + cargo3.getCargo() + "  " + cargoService.deletarCargoPorId(cargo3.getId()));
			LOG.info("");
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Excluir pelo menos 1 Funcionário pelo identificador");
			LOG.info("Removido Funcionario(a): " + funcionarioDeletar.getNome() + "  " + funcionarioService.deletarFuncionarioPorId(funcionarioDeletar.getId()));
			LOG.info("");
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Listar Funcionários com os seus respectivos Cargos");
			for (Funcionario funcionario : funcionarioService.listarTodosFuncionarios()) {
				LOG.info("");
				LOG.info("Funcionario : " + funcionario.toString());
			}
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Listar Cargos com a respectiva lista de Funcionários;");
			for (Cargo cargo : cargoService.listarTodosCargos()) {
				LOG.info("");
				LOG.info("Cargo : " + cargo.toString());
			}
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Listar o Nome de Funcionários em Ordem Alfabética");
			for (String nome : funcionarioService.listarNomeTodosFuncionarios()) {
				LOG.info("");
				LOG.info("Funcionario : " + nome);
			}
			LOG.info("---------------------------------------------------------------------------");
			LOG.info("Listar a Quantidade de Funcionários");
			LOG.info("Total de Funcionarios: " + funcionarioService.totalFuncionario());

			SpringApplication.exit(appContext, () -> 0);
		};
	}
}
