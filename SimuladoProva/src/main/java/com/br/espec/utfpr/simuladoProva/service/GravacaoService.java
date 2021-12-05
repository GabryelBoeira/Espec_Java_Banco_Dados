package com.br.espec.utfpr.simuladoProva.service;

import java.util.List;

import com.br.espec.utfpr.simuladoProva.model.Gravacao;

public interface GravacaoService {

	Gravacao salvarGravacao(final Gravacao gravacao);
	
	Boolean deletarGravacao(final Long id);
	
	Gravacao procurarGravacaoPorId(Long idGravacao);
	
	List<Gravacao> listarTodosCadastros();
	
}
