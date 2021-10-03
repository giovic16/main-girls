package com.accenture.academico.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.bank.dto.AgenciaDto;
import com.accenture.academico.bank.exception.ResourceNotFoundException;
import com.accenture.academico.bank.exception.ValorNuloException;
import com.accenture.academico.bank.model.Agencia;
import com.accenture.academico.bank.service.AgenciaService;



@RestController
@RequestMapping("/agencia")
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;


	@PostMapping
	public ResponseEntity<Agencia> create(@RequestBody AgenciaDto agenciaDto) throws ValorNuloException{
		Agencia agencia =  new Agencia();
		agencia = agenciaService.save(agenciaDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(agencia);

	}
	
	@GetMapping
	public ResponseEntity<List<Agencia>> getAll() {
		return ResponseEntity.ok(agenciaService.findAll());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Agencia> getById(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(agenciaService.getById(id));
	}

}
	
	

