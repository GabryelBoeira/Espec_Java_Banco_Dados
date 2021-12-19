package com.br.espec.provaDB.repository;

import com.br.espec.provaDB.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>  {

    @Query(value = "SELECT f.nome_func FROM Funcionario AS f order by f.nome_func asc", nativeQuery = true)
    List<String> findAllFuncionariosNome();

    @Query(value = "SELECT COUNT(f.id) AS total FROM Funcionario AS f", nativeQuery = true)
    Integer totalFuncionarios();

    @Modifying
    @Query("DELETE FROM Funcionario f WHERE f.id = :id")
    Integer deletefuncionarioById(@Param("id") Long funcionarioId);

}
