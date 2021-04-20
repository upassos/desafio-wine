package com.wine.desafio.service;

import java.util.List;

import com.wine.desafio.service.dto.FaixaCepDTO;

public interface FaixaCepService {

	public FaixaCepDTO salvar (FaixaCepDTO loja);
	
	public FaixaCepDTO recuperaLojaporCep(Integer cep);
	
	public FaixaCepDTO editar (Long idLoja, FaixaCepDTO loja);
	
	public void excluir (Long idLoja);
	
	public List<FaixaCepDTO> listarLojas();
	
}
