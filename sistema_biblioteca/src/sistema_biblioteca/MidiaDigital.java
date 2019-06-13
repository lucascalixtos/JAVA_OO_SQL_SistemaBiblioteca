package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MidiaDigital {

		private String Tipo;
		private String Fk_Acervo_Codigo_Acervo;
		
	private String tableName = "MIDIAS_DIGITAIS";
	private String fields	 = "Tipo, Fk_Acervo_Codigo_Acervo";
	private String keyField  = "Fk_Acervo_Codigo_Acervo";
	
	private DBQuery dbQuery = null;
	
	public MidiaDigital() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public MidiaDigital(String Fk_Acervo_Codigo_Acervo, String Tipo) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setFk_Acervo_Codigo_Acervo(Fk_Acervo_Codigo_Acervo);
		this.setTipo(Tipo);
	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getTipo(),
					this.getFk_Acervo_Codigo_Acervo()
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
		this.dbQuery.delete(this.getFk_Acervo_Codigo_Acervo());
		//this.setTipo("N");
		//return(this.dbQuery.update(this.toArray()));
	}
	
	
	public String getFk_Acervo_Codigo_Acervo() {
		return Fk_Acervo_Codigo_Acervo;
	}
	public void setFk_Acervo_Codigo_Acervo(String Fk_Acervo_Codigo_Acervo) {
		this.Fk_Acervo_Codigo_Acervo = Fk_Acervo_Codigo_Acervo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	
}
