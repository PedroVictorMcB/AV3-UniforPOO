package controller;

import java.util.Date;
import java.util.List;
import Model.ContaCorrente;
import Model.EntidadeRelacional;
import Model.IContaCorrente;
import Model.Transacao;
import Model.DBService;

public class CoreController implements IContaCorrente {
	
	private DBService db;
	private ContaCorrente contaCorrente;
	
	public CoreController(int contaCorrenteId) {
		this.db = new DBService();
		this.contaCorrente = db.queryContaCorrente(contaCorrenteId);
	}

	@Override
	public float getSaldo() {
		return this.contaCorrente.getSaldo();
	}

	@Override
	public void setSaldo(float saldo) {
		this.contaCorrente.setSaldo(saldo);
	}
	
	public List<Transacao> extrato(){
		return db.queryTransacoes(contaCorrente.getId());
	}
	
	public List<Transacao> extrato(Date inicio, Date fim){
		return db.queryTransacoes(contaCorrente.getId(), inicio, fim);
	}
}
