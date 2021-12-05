package com.br.espec.utfpr.simuladoProva.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Gravacao;
import com.br.espec.utfpr.simuladoProva.repository.GravacaoRepository;
import com.br.espec.utfpr.simuladoProva.service.CantorService;
import com.br.espec.utfpr.simuladoProva.service.GravacaoService;
import com.br.espec.utfpr.simuladoProva.service.GravadoraService;
import com.br.espec.utfpr.simuladoProva.service.MusicaService;

@Service
public class GravacaoServiceImpl implements GravacaoService {

	private GravacaoRepository gravacaoRepository;
	
	private CantorService cantorService;
	
	private GravadoraService gravadoraService;

	private MusicaService musicaService;
	
	public GravacaoServiceImpl(GravadoraService gravadoraService, GravacaoRepository gravacaoRepository, CantorService cantorService, MusicaService musicaService) {

		this.musicaService = musicaService;
		this.gravadoraService = gravadoraService;
		this.cantorService = cantorService;
		this.gravacaoRepository = gravacaoRepository;
	}

	@Override
	@Transactional
	public Gravacao salvarGravacao(final Gravacao gravacao) {

		if (gravacao.getCantor().getId() == null) {

			gravacao.setCantor(cantorService.salvarCantor(gravacao.getCantor()));
		} 
		
		if (gravacao.getGravadora().getId() == null) {

			gravacao.setGravadora(gravadoraService.salvarGravadora(gravacao.getGravadora()));
		} 
		
		if (gravacao.getMusica().getId() == null) {

			gravacao.setMusica(musicaService.salvarMusica(gravacao.getMusica()));
		} 

		return gravacaoRepository.save(gravacao);
	}

	@Override
	@Transactional
	public Boolean deletarGravacao(final Long id) {
		try {

			gravacaoRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {

			return Boolean.FALSE;
		}
	}

	@Override
	public List<Gravacao> listarTodosCadastros() {
		
		return gravacaoRepository.findAll();
	}

	@Override
	public Gravacao procurarGravacaoPorId(Long idGravacao) {
		
		return gravacaoRepository.findById(idGravacao).orElse(null);
	}

}
