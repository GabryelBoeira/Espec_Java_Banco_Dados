package com.br.espec.utfpr.simuladoProva.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Gravacao")
public class Gravacao extends AbstractPersistable<Long> {

	@Column(name = "data_gravacao", nullable = false)
	private LocalDate dtGravacao;
	
	@ManyToOne(targetEntity = Musica.class, optional = false)
	@JoinColumn(name = "id_musica", nullable = false)
	private Musica musica;
	
	@ManyToOne(targetEntity = Cantor.class, optional = false)
	@JoinColumn(name = "id_cantor", nullable = false)
	private Cantor cantor;
	
	@ManyToOne(targetEntity = Gravadora.class, optional = false)
	@JoinColumn(name = "id_gravadora", nullable = false)
	private Gravadora gravadora;
	
	public Gravacao() {}
	
	public Gravacao(LocalDate dtGravacao, Musica musica, Cantor cantor, Gravadora gravadora) {
		super();
		this.dtGravacao = dtGravacao;
		this.musica = musica;
		this.cantor = cantor;
		this.gravadora = gravadora;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public LocalDate getDtGravacao() {
		return dtGravacao;
	}

	public void setDtGravacao(LocalDate dtGravacao) {
		this.dtGravacao = dtGravacao;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public Cantor getCantor() {
		return cantor;
	}

	public void setCantor(Cantor cantor) {
		this.cantor = cantor;
	}

	public Gravadora getGravadora() {
		return gravadora;
	}

	public void setGravadora(Gravadora gravadora) {
		this.gravadora = gravadora;
	}
}
