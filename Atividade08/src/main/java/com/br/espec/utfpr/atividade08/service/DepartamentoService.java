package com.br.espec.utfpr.atividade08.service;


import com.br.espec.utfpr.atividade08.model.Departamento;

public interface DepartamentoService {
	
	Departamento procurarPrimeiroDepartamentoCadastrado();
	
	Departamento procurarDepartamentoPorCodigo(Integer codigo);
	
	//Atividade 08
	
}
