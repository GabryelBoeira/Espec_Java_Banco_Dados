package com.br.espec.utfpr.simuladoProva.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Musica")
public class Musica extends AbstractPersistable<Long> {

	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "duracao", nullable = false)
	private Integer duracao;
	
	@OneToMany(mappedBy = "id", targetEntity = Gravacao.class)
	private List<Gravacao> gravacaoList;
	
	@ManyToOne(targetEntity = Categoria.class, optional = false)
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Gravacao> getGravacaoList() {
		return gravacaoList;
	}

	public void setGravacaoList(List<Gravacao> gravacaoList) {
		this.gravacaoList = gravacaoList;
	}
}
