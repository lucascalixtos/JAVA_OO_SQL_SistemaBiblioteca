package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TCC {

		private String Fk_Acervo_Codigo_Acervo;
		
	private String tableName = "TCC";
	private String fields	 = "Fk_Acervo_Codigo_Acervo";
	private String keyField  = "Fk_Acervo_Codigo_Acervo";
	
	private DBQuery dbQuery = null;
	
	public TCC() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public TCC(String Fk_Acervo_Codigo_Acervo, String Edicao) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setFk_Acervo_Codigo_Acervo(Fk_Acervo_Codigo_Acervo);
	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getFk_Acervo_Codigo_Acervo()
			}
		);
	}
	
	public void save() {
			this.dbQuery.insert(this.toArray());
	}
	
	
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
	
	
}
