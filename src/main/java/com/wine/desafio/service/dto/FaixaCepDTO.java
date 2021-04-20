package com.wine.desafio.service.dto;

public class FaixaCepDTO {
	private Long id;
	private String codigoLoja;
	private Integer faixaInicio;
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

