package com.accenture.academico.bank.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;


public class ClienteDto{
		@Id
	    private Long idCliente;

	    
		@Column(name ="nome_cliente")
		@NotBlank(message = "Nome é obrigatório")
		@Size(max = 45)
	    private String nome;
		
		@Column(name ="cpf")
		@NotBlank(message = "Cpf é obrigatório")
		@Size(max = 14)
	    @CPF(message="CPF inválido")
	    private String cpf;

	  
		@Column(name ="telefone_cliente")
		@NotBlank (message = "Telefone é obrigatório")
		@Size(max = 15)
	    private String telefone;
		
		public ClienteDto(Long idCliente, String nome, String cpf, String telefone) {
			this.idCliente = idCliente;
			this.nome = nome;
			this.cpf = cpf;
			this.telefone = telefone;
		}

		public Long getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}	
}
