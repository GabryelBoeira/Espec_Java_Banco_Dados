package com.br.espec.utfpr.atividade05.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractPersistable<Long> {

	@Column(name = "codigo_func", nullable = false)
	private String codigo;

	@Column(name = "nome_func", nullable = false)
	private String nome;

	@Column(name = "cargo_func", nullable = false)
	private String cargo;

	@Column(name = "qtdeDependentes_func", nullable = false)
	private String qtdeDependentes;

	@Column(name = "salario_func", nullable = false)
	private String salario;

	@OneToMany(mappedBy = "DEPARTAMENTOS", cascade = CascadeType.PERSIST)
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamento;

	@Override
	public void setId(Long id) {

		super.setId(id);
	}
}
