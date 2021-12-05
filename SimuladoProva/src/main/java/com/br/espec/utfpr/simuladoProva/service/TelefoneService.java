package com.br.espec.utfpr.simuladoProva.service;

import java.util.List;

import com.br.espec.utfpr.simuladoProva.model.Telefone;

public interface TelefoneService {

	Telefone salvarTelefone(final Telefone telefone);

	Boolean deletarTelefone(final Long id);
	
	List<Telefone> listarTodosCadastros();
	
	List<Telefone> listarTodosCadastrosPorTipo(char tipo);
	
	List<Telefone> listarTodosCadastrosPorPessoa(Long idPessoa);	
}
