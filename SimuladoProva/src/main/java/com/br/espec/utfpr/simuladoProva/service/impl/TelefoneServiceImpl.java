package com.br.espec.utfpr.simuladoProva.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Telefone;
import com.br.espec.utfpr.simuladoProva.repository.PessoaRepository;
import com.br.espec.utfpr.simuladoProva.repository.TelefoneRepository;
import com.br.espec.utfpr.simuladoProva.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService {

	private TelefoneRepository telefoneRepository;
	
	private PessoaRepository pessoaRepository;

	public TelefoneServiceImpl(TelefoneRepository telefoneRepository, PessoaRepository pessoaRepository) {

		this.pessoaRepository = pessoaRepository;
		this.telefoneRepository = telefoneRepository;
	}

	@Override
	@Transactional
	public Telefone salvarTelefone(final Telefone telefone) {
		if (telefone.getPessoa() == null) {

			telefone.setPessoa(pessoaRepository.save(telefone.getPessoa()));
			return telefoneRepository.save(telefone);
		} else {

			return telefoneRepository.save(telefone);
		}
	}

	@Override
	@Transactional
	public Boolean deletarTelefone(final Long id) {
		try {

			telefoneRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {

			return Boolean.FALSE;
		}
	}

}
