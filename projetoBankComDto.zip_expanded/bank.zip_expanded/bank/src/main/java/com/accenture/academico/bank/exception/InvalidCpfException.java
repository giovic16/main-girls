package com.accenture.academico.bank.exception;

public class InvalidCpfException extends Exception {

	private static final long serialVersionUID = 1L;
	public InvalidCpfException(String cpf) {
		super(cpf +" Este CPF é inválido");
	}

}
