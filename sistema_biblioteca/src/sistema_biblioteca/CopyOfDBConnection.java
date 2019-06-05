package sistema_biblioteca;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CopyOfDBConnection {

	private Statement statement = null;

	public CopyOfDBConnection() {
		String usuario = "ALUNO035";
		String senha = "ALUNO035";
		String url = "jdbc:sqlserver://bdalunos.ifspguarulhos.edu.br:1433;databaseName=ALUNO035"+
					 ";user=" + usuario + ";password=" + senha + ";";
	
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String schema = null;
		try {
			schema = connection.getSchema();
			this.statement = connection.createStatement();
		} catch 	(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("Successful connection - Schema: " + schema);
	//String selectSql = "SELECT * FROM ASSOCIADO" ;
	

	}
  
	public Statement getStatement() {
		
		return( this.statement );

	}
	
	
}