package com.br.espec.utfpr.simuladoProva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.simuladoProva.model.Gravadora;

@Repository
public interface GravadoraRepository extends JpaRepository<Gravadora, Long> {

	@Query("from Gravadora where pais LIKE '%'|| :descPais ||'%'")
	List<Gravadora> findAllByPaisLike(@Param("descPais") String descPais);
}
