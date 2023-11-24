package controller;

import java.util.Date;
import java.util.List;
import Model.ContaCorrente;
import Model.EntidadeRelacional;
import Model.IContaCorrente;
import Model.Transacao;
import Model.DBService;

public class contaCorrenteController extends EntidadeRelacional implements IContaCorrente {
	
	private DBService db = new DBService();
	private ContaCorrente contaCorrente;
	//ContaCorrente contaCorrente = db.queryContaCorrente(1);
	
	public contaCorrenteController(int id, DBService db) {
		super(id);
		this.db = db;
		this.contaCorrente = db.queryContaCorrente(id);
	}

	@Override
	public float getSaldo() {
		return this.contaCorrente.getSaldo();
	}

	@Override
	public void setSaldo(float saldo) {
		this.contaCorrente.setSaldo(saldo);
	}
	
	public List<Transacao> extrato(ContaCorrente contaCorrente){
		
	}
	
	public List<Transacao> extrato(ContaCorrente contaCorrente, Date inicio, Date fim){
		
	}
}
