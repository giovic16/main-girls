package com.accenture.academico.bank.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AgenciaDto {
	
	@Id
    private Long idAgencia;

    @NotBlank(message ="Nome da agencia é obrigatório")
    @Size(max = 45)
    private String nomeAgencia;

    @NotBlank(message = "Endereço da agencia é obrigatório")
    @Size(max = 45)
    private String endereco;

    @NotBlank(message ="Telefone da agencia é obrigatório")
    @Size(max = 15)
    private String telefone;
    
    public AgenciaDto(long idAgencia, String nomeAgencia, String endereco, String telefone) {
    	this.idAgencia = idAgencia;
    	this.nomeAgencia = nomeAgencia;
    	this.endereco = endereco;
    	this.telefone = telefone;
    }

    public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}

	

	

