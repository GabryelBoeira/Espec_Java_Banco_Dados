package com.br.espec.utfpr.atividade07.service;


import com.br.espec.utfpr.atividade07.model.Departamento;

public interface DepartamentoService {
	
	Departamento procurarPrimeiroDepartamentoCadastrado();
	
	Departamento procurarDepartamentoPorCodigo(Integer codigo);
}
