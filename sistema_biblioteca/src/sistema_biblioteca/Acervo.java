package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Acervo {

	private String Codigo_Acervo;
	private String Data_entrada;
	private String Publicacao;
	private String Autor;
	private String Tipo;
	private String Tombo;
	private String Titulo;
	private String Patrimonio;


	
	private String tableName = "ACERVO";
	private String fields	 = "Codigo_Acervo, Data_entrada, Publicacao, "
							+ "Autor, Tipo, Tombo, Patrimonio, Titulo";
	private String keyField  = "Codigo_Acervo";
	
	private DBQuery dbQuery = null;
	
	public Acervo() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public Acervo(String Codigo_Acervo, String Data_entrada, String Publicacao, String Autor, String Tipo) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setCodigo_Acervo(Codigo_Acervo);
		this.setData_entrada(Data_entrada);
		this.setPublicacao(Publicacao);
		this.setAutor(Autor);
		this.setTipo(Tipo);
		this.setTombo(Tombo);
		this.setPatrimonio(Patrimonio);
		this.setTitulo(Titulo);


	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getCodigo_Acervo(),
					this.getData_entrada(),
					this.getPublicacao(),
					this.getAutor(),
					this.getTipo(),
					this.getTombo(),
					this.getPatrimonio(),
					this.getTitulo()


			}
		);
	}
	
	public void save() {
			this.dbQuery.insert(this.toArray());
	}
	
	/*public boolean checkData_entrada(String user, String Publicacao) {
		ResultSet rs = this.dbQuery.select(" Data_entrada='"+user+"' AND Publicacao='"+Publicacao+"' AND Tipo='S'");
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
		this.dbQuery.delete(this.getCodigo_Acervo());
		//this.setTipo("N");
		//return(this.dbQuery.update(this.toArray()));
	}
	public String getCodigo_Acervo() {
		return Codigo_Acervo;
	}
	public void setCodigo_Acervo(String Codigo_Acervo) {
		this.Codigo_Acervo = Codigo_Acervo;
	}
	
	
	
	public String getData_entrada() {
		return Data_entrada;
	}
	public void setData_entrada(String Data_entrada) {
		this.Data_entrada = Data_entrada;
	}
	public String getPublicacao() {
		return Publicacao;
	}
	public void setPublicacao(String Publicacao) {
		this.Publicacao = Publicacao;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String Autor) {
		this.Autor = Autor;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	
	public String getTombo() {
		return Tombo;
	}
	public void setTombo(String Tombo) {
		this.Tombo = Tombo;
	}
		
	public String getPatrimonio() {
		return Patrimonio;
	}
	public void setPatrimonio(String Patrimonio) {
		this.Patrimonio = Patrimonio;
	}
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String Titulo) {
		this.Titulo = Titulo;
	}
}
