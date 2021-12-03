package com.br.espec.utfpr.simuladoProva.service;

import com.br.espec.utfpr.simuladoProva.model.Pessoa;

public interface PessoaService {

	Pessoa salvarPessoa(final Pessoa pessoa);
	
	Boolean deletarPessoa(final Long id);
}
