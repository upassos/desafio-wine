package com.wine.desafio.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wine.desafio.models.FaixaCep;

public interface FaixaCepRepository extends JpaRepository<FaixaCep, Long> {
	
	@Query(nativeQuery=true, value = "SELECT * FROM WINECEPS.FAIXACEP "
			+" WHERE (:faixaInicio BETWEEN WINECEPS.FAIXACEP.FAIXA_INICIO AND WINECEPS.FAIXACEP.FAIXA_FIM) "
			+" OR (:faixaFim BETWEEN WINECEPS.FAIXACEP.FAIXA_INICIO AND WINECEPS.FAIXACEP.FAIXA_FIM)" )
	List<FaixaCep> validaFaixaCep(Integer faixaInicio, Integer faixaFim);

	@Query(nativeQuery=true, value = "SELECT * FROM WINECEPS.FAIXACEP "
			+" WHERE (:cep BETWEEN WINECEPS.FAIXACEP.FAIXA_INICIO AND WINECEPS.FAIXACEP.FAIXA_FIM) ")
	FaixaCep recuperaLoja(Integer cep);
}