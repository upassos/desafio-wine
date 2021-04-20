package com.wine.desafio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FAIXACEP")
public class FaixaCep {
	@Id
	@Column(name="IDFAIXACEP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="CODIGO_LOJA", length=45, nullable=false, unique=true)
	private String codigoLoja;
	@Column(name="FAIXA_INICIO", length=8, nullable=false)
	private Integer faixaInicio;
	@Column(name="FAIXA_FIM", length=8, nullable=false)
	private Integer faixaFim;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoLoja() {
		return codigoLoja;
	}
	public void setCodigoLoja(String codigoLoja) {
		this.codigoLoja = codigoLoja;
	}
	public Integer getFaixaInicio() {
		return faixaInicio;
	}
	public void setFaixaInicio(Integer faixaInicio) {
		this.faixaInicio = faixaInicio;
	}
	public Integer getFaixaFim() {
		return faixaFim;
	}
	public void setFaixaFim(Integer faixaFim) {
		this.faixaFim = faixaFim;
	}
	
}