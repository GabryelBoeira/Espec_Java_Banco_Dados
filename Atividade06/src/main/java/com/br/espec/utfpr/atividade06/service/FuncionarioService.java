package com.br.espec.utfpr.atividade06.service;

import java.util.List;

import com.br.espec.utfpr.atividade06.model.Funcionario;

public interface FuncionarioService {
	
	Funcionario procurarFuncionarioPorNomeEQtdeDependentes(String nomeFunc, int qtdeDependentes);
	
	List<Funcionario> procurarFuncionariosPorDepardamento(Long departamentoId);
		
	Funcionario procurarFuncionarioComMaiorSalario();
	
	List<Funcionario> procurarTop3FuncionariosComMaiorSalario();
	
	List<Funcionario> procurarFuncionariosSemDependentes();
	
	List<Funcionario> procurarFuncionariosComSalarioMaiorQueQuery(Double salarioBase);
	
	List<Funcionario> procurarFuncionariosComSalarioMaiorQueNativeQuery(Double salarioBase);

	List<Funcionario> procurarFuncionariosPorQtdeDependentes(Integer qtde);

	List<Funcionario> procurarFuncionariosPorNome(String nome);

}
