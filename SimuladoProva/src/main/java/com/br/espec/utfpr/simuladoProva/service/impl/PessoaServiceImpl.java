package com.br.espec.utfpr.simuladoProva.service.impl;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Pessoa;
import com.br.espec.utfpr.simuladoProva.repository.PessoaRepository;
import com.br.espec.utfpr.simuladoProva.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	private PessoaRepository pessoaRepository;

	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public Pessoa salvarPessoa(final Pessoa pessoa) {
		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Boolean deletarPessoa(final Long id) {
		try {

			pessoaRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {

			return Boolean.FALSE;
		}
	}

}
