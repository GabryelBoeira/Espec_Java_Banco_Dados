package com.br.espec.utfpr.simuladoProva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.simuladoProva.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
