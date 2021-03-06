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

		return funcionarioRepository.findByNomeAndQtdeDependentes(nomeFunc, qtdeDependentes);
	}

	@Override
	public List<Funcionario> procurarFuncionariosPorDepardamento(Long departamentoId) {
		
		return funcionarioRepository.findAllByDepartamentoId(departamentoId);
	}

	@Override
	public Funcionario procurarFuncionarioComMaiorSalario() {

		return funcionarioRepository.findTopByOrderBySalarioDesc();
	}

	@Override
	public List<Funcionario> procurarTop3FuncionariosComMaiorSalario() {

		return funcionarioRepository.findTop3ByOrderBySalarioDesc();
	}

	@Override
	public List<Funcionario> procurarFuncionariosSemDependentes() {

		return funcionarioRepository.findAllByFuncionariosSemDependentes();
	}

	@Override
	public List<Funcionario> procurarFuncionariosComSalarioMaiorQueQuery(Double salarioBase) {

		return funcionarioRepository.findAllByFuncionariosComSalarioMaiorQueByQuery(salarioBase);
	}

	@Override
	public List<Funcionario> procurarFuncionariosComSalarioMaiorQueNativeQuery(Double salarioBase) {

		return funcionarioRepository.findAllByFuncionariosComSalarioMaiorQueByNativeQuery(salarioBase);
	}

	@Override
	public List<Funcionario> procurarFuncionariosPorQtdeDependentes(Integer qtde) {
		return funcionarioRepository.findAllFuncionariosByQtdeDependentes(qtde);
	}

	@Override
	public List<Funcionario> procurarFuncionariosPorNome(String nome) {
		return funcionarioRepository.findAllFuncionariosByNomeContains(nome);
	}

}
