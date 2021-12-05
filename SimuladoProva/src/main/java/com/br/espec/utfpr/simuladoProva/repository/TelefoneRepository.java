package com.br.espec.utfpr.simuladoProva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.espec.utfpr.simuladoProva.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	
	List<Telefone> findAllByTipoEquals(char tipo);
	
	List<Telefone> findAllByPessoaId(Long idPessoa);
}
