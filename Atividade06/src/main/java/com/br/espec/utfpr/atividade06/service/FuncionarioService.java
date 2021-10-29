package com.br.espec.utfpr.atividade06.service;

import java.util.List;

import com.br.espec.utfpr.atividade06.model.Funcionario;

public interface FuncionarioService {
	
	//Funcionario procurarFuncionarioPorDepardamento( salarioBase);
	
	List<Funcionario> procurarFuncionariosPorDepardamento(Long codDepartamento);
	
	List<Funcionario> procurarFuncionariosComSalarioMaiorQue(Double salarioBase);
	
}
