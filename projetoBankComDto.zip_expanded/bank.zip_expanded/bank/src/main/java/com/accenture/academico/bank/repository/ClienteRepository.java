package com.accenture.academico.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.academico.bank.dto.ClienteDto;
import com.accenture.academico.bank.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente save(ClienteDto clientDto);

}