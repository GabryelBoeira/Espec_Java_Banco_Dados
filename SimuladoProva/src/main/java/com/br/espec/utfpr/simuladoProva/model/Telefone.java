package com.br.espec.utfpr.simuladoProva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Telefone")
public class Telefone extends AbstractPersistable<Long> {

	@Column(name = "numero", nullable = false)
	private String numero;
	
	@Column(name = "tipo", nullable = false)
	private char tipo;
	
	@ManyToOne(targetEntity = Pessoa.class, optional = false)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
