package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Exemplar {

	private String Codigo;
	private String Quantidade;
	private String NF;
	private String CodigoAcervo;
	int Qtd;
		
	private String tableName = "EXEMPLAR";
	private String fields	 = "Codigo_Exemplar, Quantidade, NF, fkAcervo_Codigo_Acervo";
	private String keyField  = "Codigo_Exemplar";
	
	private DBQuery dbQuery = null;
	
	public Exemplar() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public Exemplar(String Codigo, String Quantidade, String NF, String CodigoAcervo, String Tipo) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setCodigo(Codigo);
		this.setQuantidade(Quantidade);
		this.setNF(NF);
		this.setCodigoAcervo(CodigoAcervo);
	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getCodigo(),
					this.getQuantidade(),
					this.getNF(),
					this.getCodigoAcervo()
			}
		);
	}
	
	
	
	
	public void save() {
			this.dbQuery.insert(this.toArray());
	}
	
	/*public boolean checkQuantidade(String user, String NF) {
		ResultSet rs = this.dbQuery.select(" Quantidade='"+user+"' AND NF='"+NF+"' AND Tipo='S'");
		try {
			return(rs.next());
		} catch (SQLException e) {
			return(false);
		}
	}*/
	
	public void update(){
		this.dbQuery.update(this.toArray());
	}
	
	public void updateEmprestimo(){
		this.dbQuery.updateEmprestimo(this.getCodigo(), this.Qtd);
	}
	
	public void delete() {
		this.dbQuery.delete(this.getCodigo());
		//this.setTipo("N");
		//return(this.dbQuery.update(this.toArray()));
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String Codigo) {
		this.Codigo = Codigo;
	}
	
	
	
	public String getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(String Quantidade) {
		this.Quantidade = Quantidade;
	}
	public String getNF() {
		return NF;
	}
	public void setNF(String NF) {
		this.NF = NF;
	}
	public String getCodigoAcervo() {
		return CodigoAcervo;
	}
	public void setCodigoAcervo(String CodigoAcervo) {
		this.CodigoAcervo = CodigoAcervo;
	}

	public void setQtd(int quantidade) {
		this.Qtd = quantidade;	
	}
	
	public int getQtd() {
		return Qtd;
	}
	
}
