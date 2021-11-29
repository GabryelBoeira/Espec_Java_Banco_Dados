package com.br.espec.utfpr.simuladoProva.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Categoria")
public class Categoria extends AbstractPersistable<Long> {

	@Column(name = "desc_categoria", nullable = false)
	private String descCategoria;
	
	@OneToMany(mappedBy = "id", targetEntity = Musica.class)
	private List<Musica> musicaList;
	
	public Categoria() {}
	
	public Categoria(String descCategoria) {
		super();
		this.descCategoria = descCategoria;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getDescCategoria() {
		return descCategoria;
	}

	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}

	public List<Musica> getMusicaList() {
		return musicaList;
	}

	public void setMusicaList(List<Musica> musicaList) {
		this.musicaList = musicaList;
	}	
}
