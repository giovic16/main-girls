package com.accenture.academico.bank.service;

import org.springframework.stereotype.Service;

import com.accenture.academico.bank.dto.AgenciaDto;
import com.accenture.academico.bank.exception.ResourceNotFoundException;
import com.accenture.academico.bank.exception.ValorNuloException;
import com.accenture.academico.bank.model.Agencia;
import com.accenture.academico.bank.repository.AgenciaRepository;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository agenciaRepository;

	public List<Agencia> findAll() {
		return agenciaRepository.findAll();
	}

	public Agencia getById(Long id) throws ResourceNotFoundException {
		return agenciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Agencia save(AgenciaDto agenciaDto) throws ValorNuloException {

		try {
			Agencia agencia = new Agencia();

			agencia.setIdAgencia(agenciaDto.getIdAgencia());
			agencia.setNomeAgencia(agenciaDto.getNomeAgencia());
			agencia.setEndereco(agenciaDto.getEndereco());
			agencia.setTelefone(agenciaDto.getTelefone());
			return agenciaRepository.save(agencia);
		}
		catch(ConstraintViolationException e) {
			throw new ValorNuloException(agenciaDto);		
		}

	}
}