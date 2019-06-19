package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Associado {

	private String Prontuario;
	private String Nome;
	private String Endereco;
	private String Telefone;
	private String Tipo;
	private String Senha;
	
	private String tableName = "ASSOCIADO";
	private String fields	 = "Prontuario, Nome, Endereco, Telefone, Tipo, Senha";
	private String keyField  = "Prontuario";
	
	private DBQuery dbQuery = null;
	private String ProntuarioAntigo;
	
	public Associado() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public Associado(String Prontuario, String Nome, String Endereco, String Telefone, String Tipo, String Senha) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setProntuario(Prontuario);
		this.setNome(Nome);
		this.setEndereco(Endereco);
		this.setTelefone(Telefone);
		this.setTipo(Tipo);
		this.setSenha(Senha);
	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getProntuario(),
					this.getNome(),
					this.getEndereco(),
					this.getTelefone(),
					this.getTipo(),
					this.getSenha()
			}
		);
	}
	
	public void save() {
			this.dbQuery.insert(this.toArray());
	}
	
	public boolean checkLogin(String user, String pass) {
		ResultSet rs = this.dbQuery.select("Prontuario='"+user+"' AND Senha='"+pass+"'" );
		try {
			return(rs.next());
		} catch (SQLException e) {
			return(false);
		}
	}
	
	public boolean checkLoginAdmin(String user, String pass) {
		ResultSet rs = this.dbQuery.select("Prontuario='"+user+"' AND Senha='"+pass+"' AND Tipo = 'Administrador'" );
		try {
			return(rs.next());
		} catch (SQLException e) {
			return(false);
		}
	}
	/*public boolean checkNome(String user, String Endereco) {
		ResultSet rs = this.dbQuery.select(" Nome='"+user+"' AND Endereco='"+Endereco+"' AND Tipo='S'");
		try {
			return(rs.next());
		} catch (SQLException e) {
			return(false);
		}
	}*/
	
	public void update(){
		this.dbQuery.update(this.toArray());
	}
	
	public void delete() {
		this.dbQuery.delete(this.getProntuario());
		//this.setTipo("N");
		//return(this.dbQuery.update(this.toArray()));
	}
	public String getProntuario() {
		return Prontuario;
	}
	public void setProntuario(String Prontuario) {
		this.Prontuario = Prontuario;
	}
	
	public void setProntuarioAntigo(String ProntuarioAntigo){
		this.ProntuarioAntigo = ProntuarioAntigo;
	}
	
	public String getProntuarioAntigo(){
		return ProntuarioAntigo;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String Senha) {
		this.Senha = Senha;
	}
		
}
