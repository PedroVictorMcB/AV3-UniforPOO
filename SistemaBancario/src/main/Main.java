package main;

import Model.ContaCorrente;
import Model.DBService;

public class Main {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBService db = new DBService();
		ContaCorrente contaCorrente = db.queryContaCorrente(3);
		
		System.out.println("Seu saldo é " + contaCorrente.getSaldo() + " e seu id é " + contaCorrente.getId());

	}

}
