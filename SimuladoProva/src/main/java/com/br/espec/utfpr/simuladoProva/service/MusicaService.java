package com.br.espec.utfpr.simuladoProva.service;

import com.br.espec.utfpr.simuladoProva.model.Musica;

public interface MusicaService {

	Musica salvarMusica(final Musica musica);
	
	Boolean deletarMusica(final Long id);
}
