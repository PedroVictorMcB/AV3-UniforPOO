package controller;

import java.util.List;

import Model.Transacao;

public class TransacaoController {

	private List <Transacao> transacoes;

	public TransacaoController(List<Transacao> transacoes) {
		super();
		this.transacoes = transacoes;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	};

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	};
	
	public void addTransacaoT(Transacao transacoes) {
		
	};
	
	public void removeTransacaoT(Transacao TransacaoT) {
		
	};
}
