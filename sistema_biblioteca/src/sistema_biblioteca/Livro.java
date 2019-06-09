package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Livro {

	private String ISBN;
	private String Editora;
	private String Fk_Acervo_Codigo_Acervo;
	private String Edicao;
		
	private String tableName = "LIVRO";
	private String fields	 = "ISBN, Editora, Fk_Acervo_Codigo_Acervo, Edicao";
	private String keyField  = "ISBN";
	
	private DBQuery dbQuery = null;
	
	public Livro() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public Livro(String ISBN, String Editora, String Fk_Acervo_Codigo_Acervo, String Edicao, String Tipo) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setISBN(ISBN);
		this.setEditora(Editora);
		this.setFk_Acervo_Codigo_Acervo(Fk_Acervo_Codigo_Acervo);
		this.setEdicao(Edicao);
	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getISBN(),
					this.getEditora(),
					this.getFk_Acervo_Codigo_Acervo(),
					this.getEdicao()
			}
		);
	}
	
	public void save() {
			this.dbQuery.insert(this.toArray());
	}
	
	/*public boolean checkEditora(String user, String Fk_Acervo_Codigo_Acervo) {
		ResultSet rs = this.dbQuery.select(" Editora='"+user+"' AND Fk_Acervo_Codigo_Acervo='"+Fk_Acervo_Codigo_Acervo+"' AND Tipo='S'");
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
		this.dbQuery.delete(this.getISBN());
		//this.setTipo("N");
		//return(this.dbQuery.update(this.toArray()));
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	
	
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String Editora) {
		this.Editora = Editora;
	}
	public String getFk_Acervo_Codigo_Acervo() {
		return Fk_Acervo_Codigo_Acervo;
	}
	public void setFk_Acervo_Codigo_Acervo(String Fk_Acervo_Codigo_Acervo) {
		this.Fk_Acervo_Codigo_Acervo = Fk_Acervo_Codigo_Acervo;
	}
	public String getEdicao() {
		return Edicao;
	}
	public void setEdicao(String Edicao) {
		this.Edicao = Edicao;
	}
	
}
