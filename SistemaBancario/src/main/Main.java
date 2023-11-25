package main;

import view.TelaInicial;

public class Main {

	public static void main(String[] args) {
		
		
//		DBService db = new DBService();
//		ContaCorrente contaCorrente = db.queryContaCorrente(1);
		
//		CoreController controller = new CoreController(1);
//		
//		System.out.println("Seu saldo é " + controller.getSaldo());
//		
//		try {
//			List<Transacao> extrato = controller.extrato(new SimpleDateFormat("yyyy-MM-dd").parse("2023-11-10"), new SimpleDateFormat("yyyy-MM-dd").parse("2023-11-26"));
//					//db.queryTransacoes(1, new Date(2023, 11, 10), new Date(2023, 11, 26));
//			for (Transacao t: extrato) {
//				System.out.println(
//						"ID: " + t.getId() + " VALOR: " + t.getValor() + " OPERACAO: " + t.getOperacao() + " ORIGEM: " + t.getOrigem() 
//						+ " DESTINO: " + t.getDestino()
//						+ " DATA TRANSACAO: " + t.getDataTransacao());
//			}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		TelaInicial telaMain = new TelaInicial(Integer.parseInt(args[0]));
		
		telaMain.render();
}
}
