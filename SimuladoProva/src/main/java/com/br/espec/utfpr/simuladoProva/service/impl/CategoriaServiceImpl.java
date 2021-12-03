package com.br.espec.utfpr.simuladoProva.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Categoria;
import com.br.espec.utfpr.simuladoProva.repository.CategoriaRepository;
import com.br.espec.utfpr.simuladoProva.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaRepository categoriaRepository;
	
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	@Transactional
	public Categoria salvarCategoria(final Categoria categoria) {
		
		return categoriaRepository.save(categoria);
	}

	@Override
	@Transactional
	public Boolean deletarCategoria(final Long id) {
		try {

			categoriaRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {

			return Boolean.FALSE;
		}
	}

}
