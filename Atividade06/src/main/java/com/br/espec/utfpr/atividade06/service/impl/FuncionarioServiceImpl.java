package com.br.espec.utfpr.atividade06.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.espec.utfpr.atividade06.model.Funcionario;
import com.br.espec.utfpr.atividade06.repository.FuncionarioRepository;
import com.br.espec.utfpr.atividade06.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario procurarFuncionarioPorNomeEQtdeDependentes(String nomeFunc, int qtdeDependentes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> procurarFuncionariosPorDepardamento(Long departamentoId) {
		
		return funcionarioRepository.findAllByDepartamentoId(departamentoId);
	}

	@Override
	public Funcionario procurarFuncionarioComMaiorSalario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> procurarTop3FuncionariosComMaiorSalario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> procurarFuncionariosSemDependentes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> procurarFuncionariosComSalarioMaiorQueWordKey(Double salarioBase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> procurarFuncionariosComSalarioMaiorQueNativeQuery(Double salarioBase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAll() {
		
		return funcionarioRepository.findAll();
	}

	
}
