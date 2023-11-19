package main;

import Model.ContaCorrente;
import Model.DBService;

public class Main {

	public static void main(String[] args) {
		
		DBService db = new DBService();
		ContaCorrente contaCorrente = db.queryContaCorrente(1);
		
		System.out.println("Seu saldo é " + contaCorrente.getSaldo() + " e seu id é " + contaCorrente.getId());

	}

}
