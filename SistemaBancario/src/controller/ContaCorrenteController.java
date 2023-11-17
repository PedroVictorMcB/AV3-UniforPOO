package controller;

import java.util.Date;
import java.util.List;

import Model.ContaCorrente;
import Model.IContaCorrente;
import Model.Transacao;

public class ContaCorrenteController implements IContaCorrente {

	private ContaCorrente contaCorrente;

	public ContaCorrenteController(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	public float getSaldo();
	public void setSaldo(float saldo) {
		
	};
	public List <Transacao> extrato;
	public List <Transacao> extrato(Date inicio, Date fim){
		
	};
}
