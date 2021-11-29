package com.br.espec.utfpr.simuladoProva.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Gravadora")
public class Gravadora extends AbstractPersistable<Long> {

	@Column(name = "nome_gravadora", nullable = false)
	private String nome;
	
	@Column(name = "pais_gravadora", nullable = false)
	private String pais;
	
	@OneToMany(mappedBy = "id", targetEntity = Gravacao.class)
	private List<Gravacao> gravacaoList;
	
	public Gravadora() {}
	
	public Gravadora(String nome, String pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Gravacao> getGravacaoList() {
		return gravacaoList;
	}

	public void setGravacaoList(List<Gravacao> gravacaoList) {
		this.gravacaoList = gravacaoList;
	}
}
