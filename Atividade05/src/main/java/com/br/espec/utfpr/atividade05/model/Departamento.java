package com.br.espec.utfpr.atividade05.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractPersistable<Long> {

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
	
}
