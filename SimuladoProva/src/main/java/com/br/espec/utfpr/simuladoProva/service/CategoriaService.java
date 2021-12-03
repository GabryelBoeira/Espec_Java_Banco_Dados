package com.br.espec.utfpr.simuladoProva.service;

import com.br.espec.utfpr.simuladoProva.model.Categoria;

public interface CategoriaService {

	Categoria salvarCategoria(final Categoria categoria);
	
	Boolean deletarCategoria(final Long id);
	
	
}
