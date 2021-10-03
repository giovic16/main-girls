package com.accenture.academico.bank.repository;

import java.util.List;

import com.accenture.academico.bank.dto.ContaCorrenteDto;

public interface IContaCorrenteService {

	public List<ContaCorrenteDto>getById();
	public ContaCorrenteDto getById(long id);
	public long create(ContaCorrenteDto dto);
	public boolean update(ContaCorrenteDto dto);
	public boolean delete(long id);
	
	public ContaCorrenteDto getByIdWithCliente(long id);
	public ContaCorrenteDto getByIdWithAgencia(long id);

}
