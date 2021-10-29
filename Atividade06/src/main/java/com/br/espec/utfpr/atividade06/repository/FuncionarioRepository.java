package com.br.espec.utfpr.atividade06.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.atividade06.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	List<Funcionario> findByNomeAndQtdeDependentes(Long departamentoId);
	
	@Query("select f from Funcionario f where departamento_id = ?1") 
	List<Funcionario> findAllByDepartamentoId(Long departamentoId);
	
	//List<Funcionario> findAllByQtdeDependentesOrderByNomeAsc(Integer qtde);

	
}
