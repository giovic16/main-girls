package com.accenture.academico.bank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="extrato")
public class Extrato{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idExtrato;
	
	private Date dataHoraMovimento;
	
	@Column(name = "tipo_operacao", nullable=false)
	private TipoOperacao tipoOperacao;
	
	@JsonIgnore
	@JoinColumn(name = "idContaCorrente")
	@ManyToOne(targetEntity = ContaCorrente.class)
	private ContaCorrente contaCorrente;

	
	
	public Date getDataHoraMovimento() {
		return dataHoraMovimento;
	}

	public void setDataHoraMovimento(Date dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}

	public void setTipoOperacoes(TipoOperacao deposito) {
		// TODO Auto-generated method stub
		
	}

	public void setContaCorrente(ContaCorrente byId) {
		// TODO Auto-generated method stub
		
	}

	public void setValorOperacao(double valor) {
		// TODO Auto-generated method stub
		
	}
	
}


