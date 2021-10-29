package com.br.espec.utfpr.atividade06.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Funcionario")
public class Funcionario extends AbstractPersistable<Long> {
	
	public Funcionario() {}
		
	
	public Funcionario(String codigo, String nome, String cargo, Integer qtdeDependentes, Double salario,
			Departamento departamento) {
		this.codigo = codigo;
		this.nome = nome;
		this.cargo = cargo;
		this.qtdeDependentes = qtdeDependentes;
		this.salario = salario;
		this.departamento = departamento;
	}

	@Column(name = "codigo_func", nullable = false)
	private String codigo;

	@Column(name = "nome_func", nullable = false)
	private String nome;

	@Column(name = "cargo_func", nullable = false)
	private String cargo;

	@Column(name = "qtdeDependentes_func", nullable = false)
	private Integer qtdeDependentes;

	@Column(name = "salario_func", nullable = false)
	private Double salario;

	@ManyToOne(targetEntity = Departamento.class, optional = false)
	@JoinColumn(name="departamento_id", nullable=false)
	private Departamento departamento;

	@Override
	public void setId(Long id) {

		super.setId(id);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getQtdeDependentes() {
		return qtdeDependentes;
	}

	public void setQtdeDependentes(Integer qtdeDependentes) {
		this.qtdeDependentes = qtdeDependentes;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return String.format(
				"Funcionario [codigo=%s, nome=%s, cargo=%s, qtdeDependentes=%s, salario=%s, departamento=%s]", codigo,
				nome, cargo, qtdeDependentes, salario, departamento);
	}	
	
}
