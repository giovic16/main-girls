package com.accenture.academico.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.academico.bank.repository.ExtratoRepository;

@Controller
public class ExtratoController {

	@Autowired
	private ExtratoRepository extratoRepository;

	@RequestMapping("/extrato/{idContaCorrente}")
	public String listar(Model model, @PathVariable long idContaCorrente) {

		model.addAttribute("extrato", extratoRepository.findAllByIdConta(idContaCorrente));
		
		return "extrato";
	}
}


	