package com.br.espec.utfpr.simuladoProva.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Gravadora;
import com.br.espec.utfpr.simuladoProva.repository.GravadoraRepository;
import com.br.espec.utfpr.simuladoProva.service.GravadoraService;

@Service
public class GravadoraServiceImpl implements GravadoraService {

	private GravadoraRepository gravadoraRepository;
	
	public GravadoraServiceImpl(GravadoraRepository gravadoraRepository) {
		
		this.gravadoraRepository = gravadoraRepository;
	}

	@Override
	@Transactional
	public Gravadora salvarGravadora(final Gravadora gravadora) {
		
		return gravadoraRepository.save(gravadora);
	}

	@Override
	public Boolean deletarGravadora(final Long id) {
		try {
			
			gravadoraRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			
			return Boolean.FALSE;
		}
	}

	@Override
	public List<Gravadora> listarTodosCadastros() {
		
		return gravadoraRepository.findAll();
	}

	@Override
	public List<Gravadora> listarTodosCadastrosPorPais(String pais) {
		
		return gravadoraRepository.findAllByPaisLike(pais);
	}
}
