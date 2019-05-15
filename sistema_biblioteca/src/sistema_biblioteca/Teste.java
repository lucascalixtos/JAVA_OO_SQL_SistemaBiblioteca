package sistema_biblioteca;

import java.sql.SQLException;

public class Teste {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnection conexao = new DBConnection();
		conexao.Conecta();
		new MainFrame();
		}
	}
