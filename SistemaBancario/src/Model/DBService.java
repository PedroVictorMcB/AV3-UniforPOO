package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

	private Connection connection = null;
	private Statement statement = null;
	
	public DBService () {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\PEDRO\\Desktop\\Cursos\\UNIFOR\\ADS\\segundo-semestre\\POO\\AV3\\AV3-UniforPOO\\SistemaBancario\\src\\dataBase\\WestBank.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30); //Wait only 30 seconds to connect
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
	
}
