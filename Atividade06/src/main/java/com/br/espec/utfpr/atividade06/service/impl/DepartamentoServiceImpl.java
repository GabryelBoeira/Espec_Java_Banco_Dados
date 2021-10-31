package com.br.espec.utfpr.atividade06.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.espec.utfpr.atividade06.model.Departamento;
import com.br.espec.utfpr.atividade06.repository.DepartamentoRepository;
import com.br.espec.utfpr.atividade06.service.DepartamentoService;

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
}
