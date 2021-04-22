package com.wine.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wine.desafio.service.FaixaCepService;
import com.wine.desafio.service.dto.FaixaCepDTO;

@RestController
@RequestMapping("/faixacepcontroller")
public class FaixaCepController {

	@Autowired
	private FaixaCepService faixaCepService;
	
	@CrossOrigin
	@PostMapping("/loja")
	public FaixaCepDTO salvaLoja(@RequestBody FaixaCepDTO loja){
		return faixaCepService.salvar(loja);
	} 
	
	@CrossOrigin
	@GetMapping("/listalojas")
	public List<FaixaCepDTO> listaLojasAll(){
		return faixaCepService.listarLojas();
	} 
	
	@CrossOrigin
	@GetMapping("/recuperaLoja/{cep}")
	public FaixaCepDTO lojaPorCep(@PathVariable("cep") Integer cep){
		return faixaCepService.recuperaLojaporCep(cep);
	} 
	
	@CrossOrigin
	@PatchMapping("/loja/{idLoja}")
	public FaixaCepDTO lojaPorCep(@RequestBody FaixaCepDTO loja, @PathVariable("idLoja") Long idLoja){
		return faixaCepService.editar(idLoja, loja);
	} 	
	
	@CrossOrigin
	@DeleteMapping("/loja/{idLoja}")
	public void removeLoja(@PathVariable("idLoja") Long idLoja){
		faixaCepService.excluir(idLoja);
	} 
	
}
