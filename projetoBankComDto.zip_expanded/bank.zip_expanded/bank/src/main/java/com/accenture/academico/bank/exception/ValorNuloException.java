package com.accenture.academico.bank.exception;


public class ValorNuloException extends Exception {

	private static final long serialVersionUID = 1L;
	public ValorNuloException(Object a) {
        super("Valor não pode ser nulo " + a);
    }

}
