package com.br.espec.utfpr.simuladoProva.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Pessoa")
public class Pessoa extends AbstractPersistable<Long> {

	@Column(name = "nome_pessoa", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "id", targetEntity = Telefone.class)
	private List<Telefone> telefoneList;
	
	public Pessoa() {}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
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

	public List<Telefone> getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(List<Telefone> telefoneList) {
		this.telefoneList = telefoneList;
	}
}
