package com.br.espec.utfpr.simuladoProva.service;

import com.br.espec.utfpr.simuladoProva.model.Gravacao;

public interface GravacaoService {

	Gravacao salvarGravacao(final Gravacao gravacao);
	
	Boolean deletarGravacao(final Long id);
}
