package com.br.espec.utfpr.atividade07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.atividade07.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	// Atividade 06
	Funcionario findByNomeAndQtdeDependentes(String nome, Integer qtdeDependentes);
	
	@Query("from Funcionario where departamento.id = ?1")
	List<Funcionario> findAllByDepartamentoId(long departamentoId);

	Funcionario findTopByOrderBySalarioDesc();

	List<Funcionario> findTop3ByOrderBySalarioDesc();

	@Query("from Funcionario where qtdeDependentes = 0 order by nome asc")
	List<Funcionario> findAllByFuncionariosSemDependentes();

	@Query("from Funcionario where salario > ?1")
	List<Funcionario> findAllByFuncionariosComSalarioMaiorQueByQuery(Double salarioBase);

	@Query(value = "select * from Funcionarios as f where f.salario_func > ?1 order by f.salario_func desc", nativeQuery = true)
	List<Funcionario> findAllByFuncionariosComSalarioMaiorQueByNativeQuery(Double salarioBase);

	@Query(name = "Funcionario.byQtdeDependentes_NamedQuery")
	List<Funcionario> findAllFuncionariosByQtdeDependentes(Integer qtde);

	@Query(name = "Funcionario.byContainsNome_NamedNativeQuery")
	List<Funcionario> findAllFuncionariosByNomeContains(@Param("nome") String nome);
	
	// Atividade 07
	@Procedure(procedureName = "procedure_aumentar_salario", outputParameterName = "res")
	Integer procedureAumentarSalarioFuncionarios(Integer arg1);
	
	@Query("from Funcionario where departamento.id = :deparId and qtdeDependentes = 0")
	List<Funcionario> findAllFuncionariosPorDepartamentoSemDependentes(@Param("deparId") long departamentoId);
	
	@Modifying
	@Query(value = "UPDATE Funcionarios as f SET f.departamento_id = :newDepar WHERE f.departamento_id = :oldDepar", nativeQuery = true )
	Integer updateDepartamentoFuncionario(@Param("newDepar") Long newDepartamentoId, @Param("oldDepar") Long oldDepartamentoId);
	
	@Modifying 
	@Query("DELETE FROM Funcionario f WHERE f.departamento.id = :deparId")
	Integer deleteAllfuncionariosByDepartamentoId(@Param("deparId") Long departamentoId);
	
}
