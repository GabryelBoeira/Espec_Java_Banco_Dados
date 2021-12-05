package com.br.espec.utfpr.simuladoProva.service;

import java.util.List;

import com.br.espec.utfpr.simuladoProva.model.Cantor;

public interface CantorService {

	Cantor salvarCantor(final Cantor cantor);
	
	Boolean deletarCantor(final Long id);
	
	List<Cantor> listarTodosCadastros();
	
	List<Cantor> listarTodosCadastrosPorPais(String pais);
	
}
