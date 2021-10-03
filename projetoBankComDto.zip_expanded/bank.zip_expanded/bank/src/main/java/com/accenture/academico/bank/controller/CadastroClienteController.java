package com.accenture.academico.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.accenture.academico.bank.dto.ClienteDto;
import com.accenture.academico.bank.exception.ValorNuloException;
import com.accenture.academico.bank.service.ClienteService;

@RestController
public class CadastroClienteController {
	@Autowired
	ClienteService clienteService;
	
	public void addviewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/cadastrado").setViewName("cadastrado");
	}

	@GetMapping("/cadastrocliente")
	public String showForm(ClienteDto clienteDto) {
		return "cadastrocliente";
	}

	@PostMapping("/cadastrocliente")
	public String checkPersonInfo(@Valid ClienteDto clienteDto, BindingResult bindingResult) throws ValorNuloException {
		
		if (bindingResult.hasErrors()) {
			
			return "cadastrocliente";
		}
		
		if (ClienteService.validaCPF(clienteDto.getCpf())){
			
			clienteService.save(clienteDto);
			
			return "redirect:/cadastrado";
		}
		
			return "redirect:/errocpf";
	}
}
