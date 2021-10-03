package com.accenture.academico.bank.service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.accenture.academico.bank.dto.ContaCorrenteDto;
import com.accenture.academico.bank.exception.ResourceNotFoundException;
import com.accenture.academico.bank.exception.ValorNuloException;
import com.accenture.academico.bank.model.Cliente;
import com.accenture.academico.bank.model.ContaCorrente;
import com.accenture.academico.bank.model.Extrato;
import com.accenture.academico.bank.model.TipoOperacao;
import com.accenture.academico.bank.repository.ContaCorrenteRepository;
import com.accenture.academico.bank.repository.ExtratoRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	@Autowired
	private ClienteService cliente; //clienteService 
	@Autowired
	private AgenciaService agencia;
	@Autowired
	private ExtratoRepository extratoRepository;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public List<ContaCorrente> findAll() {
		return contaCorrenteRepository.findAll();
	}

	public ContaCorrente getById(Long id) throws ResourceNotFoundException{
		return contaCorrenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public ContaCorrente save(ContaCorrenteDto contaCorrenteDto) {

		try {
			ContaCorrente contaCorrente = new ContaCorrente();

			contaCorrente.setIdContaCorrente(contaCorrenteDto.getIdContaCorrente());
			contaCorrente.setSaldo(contaCorrenteDto.getSaldo());
			contaCorrente.setCliente(contaCorrenteDto.getIdCliente()); //contaCorrente.setCliente(cliente.getById(contaCorrenteDto.getIdCliente()));
			contaCorrente.setAgencia(contaCorrenteDto.getIdAgencia()); //contaCorrente.setAgencia(agencia.getById(contaCorrenteDto.getIdAgencia()));

			return contaCorrenteRepository.save(contaCorrente);
		}
		catch(InvalidDataAccessApiUsageException e) {
			throw new ValorNuloException(contaCorrenteDto);	
		}

	}

	public String Depositar(long idContaCorrente, double valor) throws ResourceNotFoundException {

		try {
			contaCorrenteRepository.getById(idContaCorrente).setSaldo(contaCorrenteRepository.getById(idContaCorrente).getSaldo() + valor);

			Extrato extrato = new Extrato();
			extrato.setContaCorrente(contaCorrenteRepository.getById(idContaCorrente));
			extrato.setTipoOperacoes(TipoOperacao.DEPOSITO);
			extrato.setValorOperacao(valor);
			

			extratoRepository.save(extrato);

			return "Deposito efetuado com sucesso!";
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idContaCorrente);
		}

	}

	public String Sacar(long idContaCorrente, double valor) throws ResourceNotFoundException {

		try {
			if (valor > contaCorrenteRepository.getById(idContaCorrente).getSaldo()) {
				return "Saldo insuficiente para realizar a operação.";
			} else {
				contaCorrenteRepository.getById(idContaCorrente).setSaldo(contaCorrenteRepository.getById(idContaCorrente).getSaldo() - valor);

				Extrato extrato = new Extrato();
				extrato.setContaCorrente(contaCorrenteRepository.getById(idContaCorrente));
				extrato.setTipoOperacoes(TipoOperacao.SAQUE);
				extrato.setValorOperacao(valor);
				//extrato.setDataHora(LocalDateTime.now().format(formatter));

				extratoRepository.save(extrato);

				return "Saque efetuado!";
			}
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idContaCorrente);
		}
	}

	public String Transferir (long idContaOrigem, long idContaDestino, double valorTransfer) throws ResourceNotFoundException {

		if (contaCorrenteRepository.existsById(idContaOrigem) && contaCorrenteRepository.existsById(idContaDestino)) {
			if (contaCorrenteRepository.getById(idContaOrigem).getSaldo() > valorTransfer) {
				contaCorrenteRepository.getById(idContaOrigem).setSaldo(contaCorrenteRepository.getById(idContaOrigem).getSaldo() - valorTransfer);

				Extrato extrato = new Extrato();
				extrato.setContaCorrente(contaCorrenteRepository.getById(idContaDestino));
				extrato.setTipoOperacoes(TipoOperacao.TRANSFERENCIA);
				extrato.setValorOperacao(valorTransfer);
				//extrato.setDataHora(LocalDateTime.now().format(formatter));
				extratoRepository.save(extrato);

				contaCorrenteRepository.getById(idContaDestino).setSaldo(contaCorrenteRepository.getById(idContaDestino).getSaldo() + valorTransfer);

				return "Transferência realizada com sucesso!";

			} else {

				return "Saldo insuficiente para realizar a operação.";
			}
		}
		else {
			if (contaCorrenteRepository.existsById(idContaOrigem)){
				throw new ResourceNotFoundException(idContaDestino);
			}
			else if (contaCorrenteRepository.existsById(idContaDestino)) {
				throw new ResourceNotFoundException(idContaOrigem);
			}

			throw new ResourceNotFoundException(idContaOrigem, idContaDestino);
		}

	}


	public String RetornarSaldo (long idContaCorrente) {

		try {
			Extrato extrato = new Extrato();
			extrato.setContaCorrente(contaCorrenteRepository.getById(idContaCorrente));
			extrato.setTipoOperacoes(TipoOperacao.SALDO);
			extrato.setValorOperacao(contaCorrenteRepository.getById(idContaCorrente).getSaldo());
			extrato.setDataHora(LocalDateTime.now().format(formatter));
			extratoRepository.save(extrato);

			return "O saldo atual é: " + contaCorrenteRepository.getById(idContaCorrente).getSaldo();	
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(idContaCorrente);
		}
		
	}
	
}
