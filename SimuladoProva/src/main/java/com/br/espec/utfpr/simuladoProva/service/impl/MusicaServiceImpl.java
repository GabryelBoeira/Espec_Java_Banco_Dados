package com.br.espec.utfpr.simuladoProva.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Musica;
import com.br.espec.utfpr.simuladoProva.repository.MusicaRepository;
import com.br.espec.utfpr.simuladoProva.service.CategoriaService;
import com.br.espec.utfpr.simuladoProva.service.MusicaService;

@Service
public class MusicaServiceImpl implements MusicaService {

	private MusicaRepository musicaRepository;

	private CategoriaService categoriaService;

	public MusicaServiceImpl(MusicaRepository musicaRepository, CategoriaService categoriaService) {

		this.musicaRepository = musicaRepository;
		this.categoriaService = categoriaService;
	}

	@Override
	@Transactional
	public Musica salvarMusica(final Musica musica) {

		if (musica.getCategoria().getId() == null) {

			musica.setCategoria(categoriaService.salvarCategoria(musica.getCategoria()));
		}

		return musicaRepository.save(musica);
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

	@Override
	public List<Musica> listarTodosCadastros() {

		return musicaRepository.findAll();
	}

	@Override
	public List<Musica> listarTodosCadastrosPorCategoria(Long idCategoria) {

		return musicaRepository.findAllByCategoriaId(idCategoria);
	}

}
