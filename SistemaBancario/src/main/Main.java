package main;

import java.util.Date;
import java.util.List;

import Model.ContaCorrente;
import Model.DBService;
import Model.Transacao;

public class Main {

	public static void main(String[] args) {
		
		
		DBService db = new DBService();
		ContaCorrente contaCorrente = db.queryContaCorrente(1);
		
		System.out.println("Seu saldo é " + contaCorrente.getSaldo() + " e seu id é " + contaCorrente.getId());
		
		List<Transacao> transacoes = db.queryTransacoes(1, new Date(2023, 11, 10), new Date(2023, 11, 26));
		for (Transacao t: transacoes) {
			System.out.println("ID: " + t.getId() + " VALOR: " + t.getValor() + " OPERACAO: " + t.getOperacao() + " ORIGEM: " + t.getOrigem() + " DESTINO: " + t.getDestino()
			+ " DATA TRANSACAO: " + t.getDataTransacao());
		}

}
}
