package com.accenture.academico.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contaCorrente")
public class ContaCorrente{
	
	@Id
	@SequenceGenerator(name="idContaCorrenteGen", sequenceName = "idContaCorrenteGen", initialValue=1)
	private long idContaCorrente;
	
	@Column(name="saldo")
	@NotBlank(message ="Saldo é obrigatório")
	private double saldo;

	@JoinColumn(name="idCliente", referencedColumnName ="idCliente")
	private Cliente cliente;
	
	
	@JoinColumn(name ="idAgencia")
	@ManyToOne(targetEntity = Agencia.class)
	private Agencia agencia;
	
	public long getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	
	}


