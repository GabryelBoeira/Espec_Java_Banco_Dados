package com.br.espec.utfpr.simuladoProva.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Musica;
import com.br.espec.utfpr.simuladoProva.repository.CategoriaRepository;
import com.br.espec.utfpr.simuladoProva.repository.MusicaRepository;
import com.br.espec.utfpr.simuladoProva.service.MusicaService;

@Service
public class MusicaServiceImpl implements MusicaService {

	private MusicaRepository musicaRepository;
	
	private CategoriaRepository categoriaRepository; 

	public MusicaServiceImpl(MusicaRepository musicaRepository, CategoriaRepository categoriaRepository) {

		this.musicaRepository = musicaRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	@Transactional
	public Musica salvarMusica(final Musica musica) {
		
		if (musica.getCategoria().getId() == null) {
			
			musica.setCategoria(categoriaRepository.save(musica.getCategoria()));
			return musicaRepository.save(musica);
		} else {
			
			return musicaRepository.save(musica);
		}		
	}

	@Override
	@Transactional
	public Boolean deletarMusica(final Long id) {
		try {
			
			musicaRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			
			return Boolean.FALSE;
		}
	}

}
