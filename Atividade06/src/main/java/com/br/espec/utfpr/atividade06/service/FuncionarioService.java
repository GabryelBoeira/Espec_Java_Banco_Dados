package com.br.espec.utfpr.atividade06.service;

import java.util.List;

import com.br.espec.utfpr.atividade06.model.Funcionario;

public interface FuncionarioService {
	
	List<Funcionario> findAll();
	
	Funcionario procurarFuncionarioPorNomeEQtdeDependentes(String nomeFunc, int qtdeDependentes);
	
	List<Funcionario> procurarFuncionariosPorDepardamento(Long codDepartamento);
		
	Funcionario procurarFuncionarioComMaiorSalario();
	
	List<Funcionario> procurarTop3FuncionariosComMaiorSalario();
	
	List<Funcionario> procurarFuncionariosSemDependentes();
	
	List<Funcionario> procurarFuncionariosComSalarioMaiorQueWordKey(Double salarioBase);
	
	List<Funcionario> procurarFuncionariosComSalarioMaiorQueNativeQuery(Double salarioBase);

}
