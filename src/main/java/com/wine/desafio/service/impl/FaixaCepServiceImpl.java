package com.wine.desafio.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine.desafio.exceptions.MensagemErroGenerica;
import com.wine.desafio.models.FaixaCep;
import com.wine.desafio.service.FaixaCepService;
import com.wine.desafio.service.dto.FaixaCepDTO;
import com.wine.desafio.service.mapper.FaixaCepMapper;
import com.wine.desafio.service.repository.FaixaCepRepository;
import com.wine.desafio.service.validation.FaixaCepServiceValidations;

@Service
@Transactional
public class FaixaCepServiceImpl implements FaixaCepService{

	@Autowired
	private FaixaCepRepository faixaCepRepository;
	@Autowired
	private FaixaCepMapper faixaCepMapper;
	@Autowired
	private FaixaCepServiceValidations faixaCepServiceValidations;
	
	
	@Override
	public FaixaCepDTO salvar(FaixaCepDTO loja) {

		if (faixaCepServiceValidations.validaFaixaCep(loja.getFaixaInicio(), loja.getFaixaFim())) {
			return faixaCepMapper.toDto(faixaCepRepository.save(faixaCepMapper.toEntity(loja)));
		}else {
			return null;
		}
	}

	@Override
	public FaixaCepDTO recuperaLojaporCep(Integer cep) {
		if (faixaCepServiceValidations.validaCep(cep)) {
			return faixaCepMapper.toDto(faixaCepRepository.recuperaLoja(cep));
		}else {
			return null;
		}
	}

	@Override
	public FaixaCepDTO editar(Long idLoja, FaixaCepDTO loja) {
		if (faixaCepServiceValidations.validaId(idLoja)) {
			Optional<FaixaCep> faixaCepOpt = faixaCepRepository.findById(idLoja);
			if (!faixaCepOpt.isEmpty()) {
				if (faixaCepServiceValidations.validaFaixaCep(loja.getFaixaInicio(), loja.getFaixaFim())) {
					return faixaCepMapper.toDto(faixaCepRepository.save(faixaCepMapper.toEntity(loja)));
				}else {
					return null;
				}	
			}else {
				throw new MensagemErroGenerica("Não existem registros para o Id informado.");
			}
		}
		return null;
	}

	@Override
	public void excluir(Long idLoja) {
		if (faixaCepServiceValidations.validaId(idLoja)) {
			Optional<FaixaCep> faixaCepOpt = faixaCepRepository.findById(idLoja);
			if (!faixaCepOpt.isEmpty()) {
				faixaCepRepository.delete(faixaCepOpt.get());
			}else {
				throw new MensagemErroGenerica("Não existem registros para o Id informado.");
			}
		}
	}

	@Override
	public List<FaixaCepDTO> listarLojas() {
		return faixaCepMapper.toDto(faixaCepRepository.findAll());
	}

}
