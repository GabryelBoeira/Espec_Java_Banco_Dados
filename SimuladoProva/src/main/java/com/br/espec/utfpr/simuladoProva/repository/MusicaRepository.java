package com.br.espec.utfpr.simuladoProva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.simuladoProva.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

	List<Musica> findAllByCategoriaId(Long idCategoria);
}
