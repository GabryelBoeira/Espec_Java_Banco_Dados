package com.br.espec.utfpr.simuladoProva.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Cantor;
import com.br.espec.utfpr.simuladoProva.repository.CantorRepository;
import com.br.espec.utfpr.simuladoProva.service.CantorService;

@Service
public class CantorServiceImpl implements CantorService {

	private CantorRepository cantorRepository;

	public CantorServiceImpl(CantorRepository cantorRepository) {

		this.cantorRepository = cantorRepository;
	}

	@Override
	@Transactional
	public Cantor salvarCantor(final Cantor cantor) {
		
		return cantorRepository.save(cantor);
	}

	@Override
	@Transactional
	public Boolean deletarCantor(final Long id) {
		try {

			cantorRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {

			return Boolean.FALSE;
		}
	}

	@Override
	public List<Cantor> listarTodosCadastros() {
		
		return cantorRepository.findAll();
	}

	@Override
	public List<Cantor> listarTodosCadastrosPorPais(String pais) {
		
		return cantorRepository.findAllByPaisEquals(pais);
	}
}
