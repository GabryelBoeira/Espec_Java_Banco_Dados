package com.br.espec.utfpr.simuladoProva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.simuladoProva.model.Cantor;

@Repository
public interface CantorRepository extends JpaRepository<Cantor, Long> {

	List<Cantor> findAllByPaisEquals(String pais);
}
