package com.br.espec.utfpr.atividade08.service;

import java.util.List;

import com.br.espec.utfpr.atividade08.model.Departamento;
import com.br.espec.utfpr.atividade08.model.Funcionario;

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
	
	//Atividade 07
	Integer aumentarTodosSalariosPorPercentual(Integer percentual);
	
	List<Funcionario> buscarTodosFuncionariosPorDepartamentoSemDependentes(Long deparId);
	
	Integer migrarFuncionariosDeDepartamento(Departamento newDepartamento, Long oldDepartamento);
	
	Integer deletarFuncionariosPorDepartamentoId(Long departamentoId);
	
	//Atividade 08	
	
	Funcionario criarFuncionarioComNovoDepartamento(Funcionario funcionario, Departamento departamento);
	
}
