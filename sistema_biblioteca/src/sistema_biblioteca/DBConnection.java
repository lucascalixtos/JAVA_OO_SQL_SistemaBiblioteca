package sistema_biblioteca;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	String usuario = "ALUNO035";
	String senha = "ALUNO035";
	String url = "jdbc:jtds:sqlserver://bdalunos.ifspguarulhos.edu.br:1433;databaseName=ALUNO035"+
				 ";user=" + usuario + ";password=" + senha + ";";
	private Statement  statement= null;
	
	public DBConnection() {
		
		System.out.println(url); 
		// println(url) só esta aqui por questões didáticas
		// retirar para colocar em produção
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			this.statement = ( DriverManager.getConnection(url).createStatement()); 
			if (statement != null)
				System.out.println("Banco de dados Conectado!");
			else
				System.out.println("Banco de dados não conectado!");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Statement getStatement() {
		return( this.statement );
	}

	
}
