package com.accenture.academico.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="agencia")
public class Agencia{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAgencia;
	
	@Column(name="nome_agencia")
	@NotBlank(message ="Nome da agencia é obrigatório")
	@Size(max=45)
	private String nomeAgencia;
	
	@Column(name="endereco_agencia")
	@NotBlank(message = "Endereço da agencia é obrigatório")
	@Size(max=45)
	private String endereco;
	
	@Column(name="telefone_agencia")
	@NotBlank(message ="Telefone da agencia é obrigatório")
	@Size(max=15)
	private String telefone;
	public long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(long idAgencia) {
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


