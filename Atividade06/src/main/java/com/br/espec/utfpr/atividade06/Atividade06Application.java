package com.br.espec.utfpr.atividade06;

import com.br.espec.utfpr.atividade06.model.Departamento;
import com.br.espec.utfpr.atividade06.model.Funcionario;
import com.br.espec.utfpr.atividade06.repository.DepartamentoRepository;
import com.br.espec.utfpr.atividade06.repository.FuncionarioRepository;
import com.br.espec.utfpr.atividade06.service.DepartamentoService;
import com.br.espec.utfpr.atividade06.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Atividade06Application {

	private static final Logger log = LoggerFactory.getLogger(Atividade06Application.class);

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {

		SpringApplication.run(Atividade06Application.class, args);
	}

	@Bean
	public CommandLineRunner Atividade06ApplicationTeste(DepartamentoService departamentoService,
			FuncionarioService funcionarioService, DepartamentoRepository departamentoRepository,
			FuncionarioRepository funcionarioRepository) {

		starData(departamentoRepository, funcionarioRepository);
		return (arg) -> {
			
			log.info("1 - Lista um funcionário pelo seu nome e quantidade de dependentes utilizando consulta por palavras-chaves.");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			log.info(funcionarioService.procurarFuncionarioPorNomeEQtdeDependentes("Jose da Silva", 2).toString());
			log.info("===========================================================================");
			log.info("");
			
			log.info("2 - Listar todos os funcion�rios de um determinado departamento por JPQL via @Query");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			for(Funcionario func : funcionarioService.procurarFuncionariosPorDepardamento(departamentoService.procurarPrimeiroDepartamentoCadastrado().getId())) {
				log.info("");
				log.info(func.toString());
			};
			log.info("===========================================================================");
			log.info("");
			
			log.info("3 - Listar o primeiro departamento cadastrado.");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			log.info(departamentoService.procurarPrimeiroDepartamentoCadastrado().toString());
			log.info("===========================================================================");
			log.info("");
			
			log.info("4 - Listar o primeiro funcion�rio que tem o maior sal�rio.");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			log.info(funcionarioService.procurarFuncionarioComMaiorSalario().toString());
			log.info("===========================================================================");
			log.info("");

			log.info("5 - Listar os 3 (trés) primeiros funcionários que tem os maiores salários.");
			log.info("----------------------------------------------------------------------------");
			log.info("");
			for(Funcionario func : funcionarioService.procurarTop3FuncionariosComMaiorSalario()) {
				log.info("");
				log.info(func.toString());
			};
			log.info("=============================================================================");
			log.info("");

			log.info("6 - Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL via @Query.");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			for(Funcionario func : funcionarioService.procurarFuncionariosSemDependentes()) {
				log.info("");
				log.info(func.toString());
			};
			log.info("===========================================================================");
			log.info("");

			log.info("7 - Listar os funcion�rios que tem sal�rio maior que um determinado valor por JPQL sobrescrevendo palavras-chaves @Query");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			for(Funcionario func : funcionarioService.procurarFuncionariosComSalarioMaiorQueQuery(2500D)) {
				log.info("");
				log.info(func.toString());
			};
			log.info("===========================================================================");
			log.info("");

			log.info("8 - Listar os funcion�rios que tem sal�rio maior que um determinado valor por @Query com native query.");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			for(Funcionario func : funcionarioService.procurarFuncionariosComSalarioMaiorQueNativeQuery(2500D)) {
				log.info("");
				log.info(func.toString());
			};
			log.info("===========================================================================");
			log.info("");

			log.info("9 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma determinada quantidade de dependentes por @NamedQuery");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			for(Funcionario func : funcionarioService.procurarFuncionariosPorQtdeDependentes(1)) {
				log.info("");
				log.info(func.toString());
			};
			log.info("===========================================================================");
			log.info("");


			log.info("10 - Alterar a classe Funcionario e criar uma consulta para listar os funcionários que contenham em qualquer parte do seu nome um determinado nome por @NamedNativeQuery");
			log.info("---------------------------------------------------------------------------");
			log.info("");
			for(Funcionario func : funcionarioService.procurarFuncionariosPorNome("Si")) {
				log.info("");
				log.info(func.toString());
			};
			log.info("===========================================================================");
			log.info("");

			SpringApplication.exit(appContext, () -> 0);
		};
	}
	
	public void starData(DepartamentoRepository departamentoRepository,
			FuncionarioRepository funcionarioRepository) {
		
		funcionarioRepository.deleteAll();
		departamentoRepository.deleteAll();
		
		Departamento dep1 = departamentoRepository.save(new Departamento("Recursos Humanos", 561));
		Departamento dep2 = departamentoRepository.save(new Departamento("Contabilidade", 5251));
		Departamento dep3 = departamentoRepository.save(new Departamento("Vendas", 58));
		Departamento dep4 = departamentoRepository.save(new Departamento("Compras", 562));
		Departamento dep5 = departamentoRepository.save(new Departamento("Suporte ao Cliente", 426));
		
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
	} 
}
