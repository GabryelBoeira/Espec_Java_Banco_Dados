package com.br.espec.utfpr.simuladoProva.service;

import java.util.List;

import com.br.espec.utfpr.simuladoProva.model.Categoria;

public interface CategoriaService {

	Categoria salvarCategoria(final Categoria categoria);
	
	Boolean deletarCategoria(final Long id);
	
	List<Categoria> listarTodosCadastros();
	
	List<Categoria> procurarPorMusica(String descricao);
}
