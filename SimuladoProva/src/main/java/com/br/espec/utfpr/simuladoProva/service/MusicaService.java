package com.br.espec.utfpr.simuladoProva.service;

import java.util.List;

import com.br.espec.utfpr.simuladoProva.model.Musica;

public interface MusicaService {

	Musica salvarMusica(final Musica musica);
	
	Boolean deletarMusica(final Long id);
	
	List<Musica> listarTodosCadastros();
	
	List<Musica> listarTodosCadastrosPorCategoria(Long idCategoria);
	
}
