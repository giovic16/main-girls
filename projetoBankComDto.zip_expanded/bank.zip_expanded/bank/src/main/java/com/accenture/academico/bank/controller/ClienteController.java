package com.accenture.academico.bank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.accenture.academico.bank.dto.ClienteDto;
import com.accenture.academico.bank.exception.ResourceNotFoundException;
import com.accenture.academico.bank.exception.ValorNuloException;
import com.accenture.academico.bank.model.Cliente;
import com.accenture.academico.bank.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ClienteDto clienteDto) throws ValorNuloException{
		clienteService.save(clienteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso");
	}
	
//	@PutMapping
//	public ResponseEntity<Cliente> update(@RequestBody ClienteDTO clienteDTO){
//		Cliente cliente = new Cliente();
//		cliente = servico.save(clienteDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		clienteService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(clienteService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(clienteService.getById(id));
	}
}
