package com.br.espec.utfpr.atividade08.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.espec.utfpr.atividade08.model.Departamento;
import com.br.espec.utfpr.atividade08.model.Funcionario;
import com.br.espec.utfpr.atividade08.repository.FuncionarioRepository;
import com.br.espec.utfpr.atividade08.service.DepartamentoService;
import com.br.espec.utfpr.atividade08.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private DepartamentoService departamentoService;
	
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
	
	//Atividade 07
	@Override
	public Integer aumentarTodosSalariosPorPercentual(Integer percentual) {		
		
		return funcionarioRepository.procedureAumentarSalarioFuncionarios(percentual);
	}

	@Override
	public List<Funcionario> buscarTodosFuncionariosPorDepartamentoSemDependentes(Long deparId) {
		
		return funcionarioRepository.findAllFuncionariosPorDepartamentoSemDependentes(deparId);
	}

	@Override
	@Transactional
	public Integer migrarFuncionariosDeDepartamento(Departamento newDepartamento, Long oldDepartamento) {
		
		return funcionarioRepository.updateDepartamentoFuncionario(newDepartamento.getId(), oldDepartamento);
	}

	@Override
	@Transactional
	public Integer deletarFuncionariosPorDepartamentoId(Long departamentoId) {
	
		return funcionarioRepository.deleteAllfuncionariosByDepartamentoId(departamentoId);
	}

	@Override
	@Transactional
	public Funcionario criarFuncionarioComNovoDepartamento(Funcionario funcionario, Departamento departamento) {
		
		Departamento departamentoSalvo = departamentoService.salvarDepartamento(departamento);
		
		funcionario.setDepartamento(departamentoSalvo);
		
		return funcionarioRepository.save(funcionario);
	}

}
