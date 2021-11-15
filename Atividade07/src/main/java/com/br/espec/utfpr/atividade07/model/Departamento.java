package com.br.espec.utfpr.atividade07.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Departamentos")
public class Departamento extends AbstractPersistable<Long> {

	public Departamento() {};
	
	public Departamento(String nomeDepartamento, Integer codigoDepardamento) {
		this.nomeDepartamento = nomeDepartamento;
		this.codigoDepardamento = codigoDepardamento;
	}

	@Column(name = "nome_depar", nullable = false)
	private String nomeDepartamento;

	@Column(name = "cod_depar", nullable = false)
	private Integer codigoDepardamento;

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public Integer getCodigoDepardamento() {
		return codigoDepardamento;
	}

	public void setCodigoDepardamento(Integer codigoDepardamento) {
		this.codigoDepardamento = codigoDepardamento;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Departamento [idDepardamento=%s, codigoDepardamento=%s, nomeDepartamento=%s]", super.getId() ,codigoDepardamento,
				nomeDepartamento);
	}	
	
}
