package com.br.espec.utfpr.simuladoProva.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.simuladoProva.model.Telefone;
import com.br.espec.utfpr.simuladoProva.repository.TelefoneRepository;
import com.br.espec.utfpr.simuladoProva.service.PessoaService;
import com.br.espec.utfpr.simuladoProva.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService {

	private TelefoneRepository telefoneRepository;

	private PessoaService pessoaService;

	public TelefoneServiceImpl(TelefoneRepository telefoneRepository, PessoaService pessoaService) {

		this.pessoaService = pessoaService;
		this.telefoneRepository = telefoneRepository;
	}

	@Override
	@Transactional
	public Telefone salvarTelefone(final Telefone telefone) {
		
		if (telefone.getPessoa().getId() == null) {

			telefone.setPessoa(pessoaService.salvarPessoa(telefone.getPessoa()));
		}
		
		return telefoneRepository.save(telefone);
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

	@Override
	public List<Telefone> listarTodosCadastros() {

		return telefoneRepository.findAll();
	}

	@Override
	public List<Telefone> listarTodosCadastrosPorTipo(char tipo) {
		
		return telefoneRepository.findAllByTipoEquals(tipo);
	}

	@Override
	public List<Telefone> listarTodosCadastrosPorPessoa(Long idPessoa) {
		
		return telefoneRepository.findAllByPessoaId(idPessoa);
	}

}
