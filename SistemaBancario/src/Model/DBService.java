package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBService {

	private Connection connection = null;
	private Statement statement = null;
	
	public DBService () {
			
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:src/dataBase/WestBank.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30); //Wait only 30 seconds to connect
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public ContaCorrente queryContaCorrente(int id) {
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM conta_corrente cc WHERE id = " + id);
			rs.next();
			int resId = rs.getInt("id");
			float resSaldo = rs.getFloat("saldo");
			return new ContaCorrente(resId, resSaldo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ContaCorrente(-1, 0);
		}
	}
	
	public List<Transacao> queryTransacoes(int contaCorrenteId){
		try {
			ResultSet rs = statement.executeQuery("SELECT t.* FROM conta_corrente cc "
					+ "INNER JOIN transacao t ON cc.id=t.conta_corrente_id "
					+ "WHERE cc.id=" + contaCorrenteId);
			ArrayList<Transacao> transacoesOutput = new ArrayList<Transacao>();
			while (rs.next()) {
				int resId = rs.getInt("id");
				float resValor = rs.getFloat("valor");
				Operacao resOperacao = Operacao.valueOf(rs.getString("operacao"));
				String resOrigem = rs.getString("origem");
				String resDestino = rs.getString("destino");
				Date resDataTransacao;
				try {
					resDataTransacao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("data_transacao"));
				} catch (ParseException e) {
					resDataTransacao = new Date();
				}  
				Transacao newTransacao = new Transacao(resId, resValor, resOperacao, resOrigem, resDestino, resDataTransacao);
				transacoesOutput.add(newTransacao);
			};
			return transacoesOutput;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Transacao>();
		}
	}
	
	public List<Transacao> queryTransacoes(int contaCorrenteId, Date inicio, Date fim){
		try {
			ResultSet rs = statement.executeQuery(
				"SELECT t.* FROM conta_corrente cc "
				+ "INNER JOIN transacao t ON cc.id=t.conta_corrente_id "
				+ "WHERE cc.id=" + contaCorrenteId + " AND t.data_transacao >= \"" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(inicio)
				+ "\" AND t.data_transacao <= \"" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fim) 
				+ "\""
			);
			ArrayList<Transacao> transacoesOutput = new ArrayList<Transacao>();
			
			while (rs.next()) {
				int resId = rs.getInt("id");
				float resValor = rs.getFloat("valor");
				Operacao resOperacao = Operacao.valueOf(rs.getString("operacao"));
				String resOrigem = rs.getString("origem");
				String resDestino = rs.getString("destino");
				Date resDataTransacao;
				try {
					resDataTransacao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("data_transacao"));
				} catch (ParseException e) {
					resDataTransacao = new Date();
				}  
				Transacao newTransacao = new Transacao(resId, resValor, resOperacao, resOrigem, resDestino, resDataTransacao);
				transacoesOutput.add(newTransacao);
			};
			return transacoesOutput;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Transacao>();
		}
	}
	
	
}
