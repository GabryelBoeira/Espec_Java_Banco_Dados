package com.br.espec.utfpr.simuladoProva.service;

import com.br.espec.utfpr.simuladoProva.model.Cantor;

public interface CantorService {

	Cantor salvarCantor(final Cantor cantor);
	
	Boolean deletarCantor(final Long id);
}
