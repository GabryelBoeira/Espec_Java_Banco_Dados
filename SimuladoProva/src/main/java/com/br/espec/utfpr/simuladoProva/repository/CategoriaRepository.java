package com.br.espec.utfpr.simuladoProva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.simuladoProva.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Query("from Categoria where descCategoria LIKE '%'|| :descricao ||'%'")
	List<Categoria> findAllByDescCategoriaLike(@Param("descricao") String descricao);

}
