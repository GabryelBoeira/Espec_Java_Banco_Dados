package com.br.espec.utfpr.atividade07.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.atividade07.model.Departamento;

@Repository
public interface  DepartamentoRepository extends JpaRepository<Departamento, Long> {

    Departamento findFirstBy();
    
    Optional<Departamento> findAllByCodigoDepardamento(Integer codigo);
}