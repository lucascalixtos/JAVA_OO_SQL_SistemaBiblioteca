package sistema_biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public void Conecta() throws SQLException, ClassNotFoundException{
	String usuario = "ALUNO035";
	String senha = "ALUNO035";
	String url = "jdbc:sqlserver://bdalunos.ifspguarulhos.edu.br:1433;databaseName=ALUNO035" +
	                       ";user=" + usuario + ";password=" + senha + ";";
	
	Connection connection = null;
	connection = DriverManager.getConnection(url);
	String schema = connection.getSchema();
	System.out.println("Successful connection - Schema: " + schema); 
	
	String selectSql = "SELECT * FROM CURSO";
	
	try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql)) {

                // Print results from select statement
                System.out.println("Resultado:");
                while (resultSet.next())
                {
                    System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
                }
                connection.close();
            } catch (Exception e) {
            e.printStackTrace();
        }
	
}
	
}
