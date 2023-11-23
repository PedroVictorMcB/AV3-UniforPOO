package controller;

import java.util.Date;
import java.util.List;

import Model.ContaCorrente;
import Model.IContaCorrente;
import Model.Transacao;

public class contaCorrenteController implements IContaCorrente {
	
	private ContaCorrente contaCorrente;
	
	public contaCorrenteController(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	@Override
	public float getSaldo(ContaCorrente contaCorrente) {
		// TODO Auto-generated method stub
		return saldo;
	}

	@Override
	public void setSaldo(float saldo) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Transacao> extrato(ContaCorrente contaCorrente){
		
	}
	
	public List<Transacao> extrato(ContaCorrente contaCorrente, Date inicio, Date fim){
		
	}
}
