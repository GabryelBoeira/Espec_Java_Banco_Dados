package com.br.espec.utfpr.atividade08.service.impl;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.atividade08.model.Departamento;
import com.br.espec.utfpr.atividade08.repository.DepartamentoRepository;
import com.br.espec.utfpr.atividade08.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	private DepartamentoRepository departamentoRepository;
	
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		
		this.departamentoRepository = departamentoRepository;
	}
	
	@Override
	public Departamento procurarPrimeiroDepartamentoCadastrado() {
		
		return departamentoRepository.findFirstBy();
	}

	@Override
	public Departamento procurarDepartamentoPorCodigo(Integer codigo) {
		
		return departamentoRepository.findAllByCodigoDepardamento(codigo).orElse(null);
	}
	
	//Atividade 08
	@Override
	public Departamento salvarDepartamento(Departamento departamento) {

		return departamentoRepository.save(departamento);
	}
}
