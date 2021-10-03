package com.accenture.academico.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.accenture.academico.bank.dto.AgenciaDto;
import com.accenture.academico.bank.model.Agencia;


@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	Agencia save(AgenciaDto agenciaDto);

}
