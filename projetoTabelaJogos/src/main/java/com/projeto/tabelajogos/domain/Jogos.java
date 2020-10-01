package com.projeto.tabelajogos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOGOS")
public class Jogos {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private int jogo;
	
	private int placar;
	
	private int minimoTemporada;
	
	private int maximoTemporada;
	
	private int recordeMinimo;
	
	private int recordeMaximo;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getJogo() {
		return jogo;
	}

	public void setJogo(int jogo) {
		this.jogo = jogo;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = placar;
	}

	public int getMinimoTemporada() {
		return minimoTemporada;
	}

	public void setMinimoTemporada(int minimoTemporada) {
		this.minimoTemporada = minimoTemporada;
	}

	public int getMaximoTemporada() {
		return maximoTemporada;
	}

	public void setMaximoTemporada(int maximoTemporada) {
		this.maximoTemporada = maximoTemporada;
	}

	public int getRecordeMinimo() {
		return recordeMinimo;
	}

	public void setRecordeMinimo(int recordeMinimo) {
		this.recordeMinimo = recordeMinimo;
	}

	public int getRecordeMaximo() {
		return recordeMaximo;
	}

	public void setRecordeMaximo(int recordeMaximo) {
		this.recordeMaximo = recordeMaximo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogos other = (Jogos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
