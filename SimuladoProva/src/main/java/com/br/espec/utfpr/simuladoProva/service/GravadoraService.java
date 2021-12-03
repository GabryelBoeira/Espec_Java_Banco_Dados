package com.br.espec.utfpr.simuladoProva.service;

import com.br.espec.utfpr.simuladoProva.model.Gravadora;

public interface GravadoraService {

	Gravadora salvarGravadora(final Gravadora gravadora);
	
	Boolean deletarGravadora(final Long id);
}
