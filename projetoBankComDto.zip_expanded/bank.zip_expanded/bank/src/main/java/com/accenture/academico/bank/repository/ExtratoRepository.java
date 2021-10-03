package com.accenture.academico.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.academico.bank.model.Extrato;


public interface ExtratoRepository extends JpaRepository<Extrato, Long> {

	@Query("FROM Extrato g where g.conta.id = :IdContaCorrente")
	List<Extrato> findAllByIdConta(long IdContaCorrente);
	
}