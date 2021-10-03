package com.accenture.academico.bank.dto;

import com.accenture.academico.bank.model.Agencia;
import com.accenture.academico.bank.model.Cliente;

public class ContaCorrenteDto{
	private long idContaCorrente;
	private float saldo;
	private Cliente cliente;
	private Agencia agencia;
	
	
	public long getIdContaCorrente() {
		return idContaCorrente;
	}
	public void setIdContaCorrente(long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
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

