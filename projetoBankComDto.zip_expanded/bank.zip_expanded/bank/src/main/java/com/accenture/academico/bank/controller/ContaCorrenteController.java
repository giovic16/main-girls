package com.accenture.academico.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.bank.dto.ContaCorrenteDto;
import com.accenture.academico.bank.exception.ResourceNotFoundException;
import com.accenture.academico.bank.model.ContaCorrente;
import com.accenture.academico.bank.service.ContaCorrenteService;



@RestController
@RequestMapping("/contaCorrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contaCorrenteService;

	@PostMapping
	public ResponseEntity<ContaCorrente> create(@RequestBody ContaCorrenteDto contaCorrenteDto) {
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente = contaCorrenteService.save(contaCorrenteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaCorrente);
	}

	@GetMapping
	public ResponseEntity<List<ContaCorrente>> getAll() {
		return ResponseEntity.ok(contaCorrenteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaCorrente> getById(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(contaCorrenteService.getById(id));
	}

	@PutMapping("/deposito")
	public ResponseEntity<String> depositando(@RequestBody long idContaCorrente, double valor) throws ResourceNotFoundException {
		return ResponseEntity.ok(contaCorrenteService.Depositar(idContaCorrente, valor));
	}

	@PutMapping("/transferencia")
	public ResponseEntity<String> transferindo(long idContaOrigem, long idContaDestino,
			double valor) throws ResourceNotFoundException {
		return ResponseEntity.ok(contaCorrenteService.Transferir(idContaOrigem, idContaDestino, valor));
	}

	@PutMapping("/saque")
	public ResponseEntity<String> sacando(@RequestBody long idConta, double valor) throws ResourceNotFoundException {
		return ResponseEntity.ok(contaCorrenteService.Sacar(idConta, valor));
	}

	@GetMapping("/visualizandoSaldo")
	public ResponseEntity<String> visualizandoSaldo(long idConta) {
		return ResponseEntity.ok(contaCorrenteService.RetornarSaldo(idConta));
	}

//ultimachave
}
		
