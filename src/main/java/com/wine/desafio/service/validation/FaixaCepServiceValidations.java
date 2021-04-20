package com.wine.desafio.service.validation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine.desafio.exceptions.MensagemErroGenerica;
import com.wine.desafio.service.dto.FaixaCepDTO;
import com.wine.desafio.service.mapper.FaixaCepMapper;
import com.wine.desafio.service.repository.FaixaCepRepository;

@Service
@Transactional
public class FaixaCepServiceValidations {

	@Autowired
	private FaixaCepRepository faixaCepRepository;
	@Autowired
	private FaixaCepMapper faixaCepMapper;
	
	public boolean validaFaixaCep(Integer faixaInicial, Integer faixaFinal) {
			
		if ((faixaInicial == null) ||
			(faixaFinal == null) || 
			(faixaInicial <= 0) || 
			(faixaFinal <= 0)) {
			throw new MensagemErroGenerica("Insira um valor válido para as faixas de CEP. Os valores devem ser positivos maiores do que zero.");
		}else {
			if (faixaInicial >= faixaFinal) {
				throw new MensagemErroGenerica("Faixa de CEP inicial deve ser menor do que a faixa de CEP final.");
			}else {
				List<FaixaCepDTO> faixaCepDto = faixaCepMapper.toDto(faixaCepRepository.validaFaixaCep(faixaInicial, faixaFinal));
				if (faixaCepDto.isEmpty()) {
					return true;
				}else {
					throw new MensagemErroGenerica("A faixa de CEP informada está sendo utilizada por outra loja.");
				}
			}
		}
	}
	
	public boolean validaCep(Integer cep) {
		
		if ((cep == null) ||
			(cep <= 0)) {
			throw new MensagemErroGenerica("Favor insira um CEP válido. (Valores positivos maiores deo que zero).");
		}else {
			return true;
		}
	}
	
	public boolean validaId(Long id) {
		
		if ((id == null) ||
			(id <= 0)) {
			throw new MensagemErroGenerica("Favor insira um Id válido. (Valores positivos maiores deo que zero).");
		}else {
			return true;
		}
	}
}

