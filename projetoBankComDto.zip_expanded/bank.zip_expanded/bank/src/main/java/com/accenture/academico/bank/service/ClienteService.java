package com.accenture.academico.bank.service;

import java.util.List;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.accenture.academico.bank.dto.ClienteDto;
import com.accenture.academico.bank.exception.DataBaseException;
import com.accenture.academico.bank.exception.InvalidCpfException;
import com.accenture.academico.bank.exception.InvalidStateException;
import com.accenture.academico.bank.exception.ResourceNotFoundException;
import com.accenture.academico.bank.exception.ValorNuloException;
import com.accenture.academico.bank.model.Cliente;
import com.accenture.academico.bank.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}


	public Cliente getById(Long id) throws ResourceNotFoundException {
		return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}


	public void save(ClienteDto clienteDto) throws ValorNuloException {

		try {
			if (validaCPF(clienteDto.getCpf())) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(clienteDto.getIdCliente());
				cliente.setCpf(clienteDto.getCpf());
				cliente.setTelefone(clienteDto.getTelefone());
				cliente.setNome(clienteDto.getNome());

				clienteRepository.save(cliente);
			}
		}
		catch(DataIntegrityViolationException e) {
			throw new ValorNuloException(clienteDto);		
		}
	}

	public void deleteById(Long id) {

		clienteRepository.deleteById(id);
	}

	//Aqui ira acontecer a validação do cpf
	public static boolean validaCPF(String cpf) {

		CPFValidator cpfValidator = new CPFValidator();
		try {
			cpfValidator.assertValid(cpf);
			return true;
		}
		catch(InvalidStateException e) {
			throw new InvalidCpfException(cpf);
		}

		
	}
	//Para deletar
	public void deleteById(long id) throws ResourceNotFoundException {

		try {
			clienteRepository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException (e.getMessage());
		}

	}
	
}
