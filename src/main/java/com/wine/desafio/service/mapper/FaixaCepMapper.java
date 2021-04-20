package com.wine.desafio.service.mapper;

import org.mapstruct.Mapper;

import com.wine.desafio.models.FaixaCep;
import com.wine.desafio.service.dto.FaixaCepDTO;

@Mapper(componentModel = "spring")
public interface FaixaCepMapper extends EntityMapper <FaixaCepDTO, FaixaCep>{

}