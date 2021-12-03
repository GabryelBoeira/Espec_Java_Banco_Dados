package com.br.espec.utfpr.simuladoProva.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Gravacao;
import com.br.espec.utfpr.simuladoProva.repository.CantorRepository;
import com.br.espec.utfpr.simuladoProva.repository.GravacaoRepository;
import com.br.espec.utfpr.simuladoProva.repository.GravadoraRepository;
import com.br.espec.utfpr.simuladoProva.repository.MusicaRepository;
import com.br.espec.utfpr.simuladoProva.service.GravacaoService;

@Service
public class GravacaoServiceImpl implements GravacaoService {

	private GravacaoRepository gravacaoRepository;
	
	private CantorRepository cantorRepository;
	
	private GravadoraRepository gravadoraRepository;

	private MusicaRepository musicaRepository;
	
	public GravacaoServiceImpl(GravadoraRepository gravadoraRepository, GravacaoRepository gravacaoRepository, CantorRepository cantorRepository, MusicaRepository musicaRepository) {

		this.musicaRepository = musicaRepository;
		this.gravadoraRepository = gravadoraRepository;
		this.cantorRepository = cantorRepository;
		this.gravacaoRepository = gravacaoRepository;
	}

	@Override
	@Transactional
	public Gravacao salvarGravacao(final Gravacao gravacao) {

		if (gravacao.getCantor().getId() == null) {

			gravacao.setCantor(cantorRepository.save(gravacao.getCantor()));
		} 
		
		if (gravacao.getGravadora().getId() == null) {

			gravacao.setGravadora(gravadoraRepository.save(gravacao.getGravadora()));
		} 
		
		if (gravacao.getMusica().getId() == null) {

			gravacao.setMusica(musicaRepository.save(gravacao.getMusica()));
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

}
