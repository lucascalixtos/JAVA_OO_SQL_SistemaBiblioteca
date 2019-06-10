package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Emprestimo {

	private String Id;
	private String DataEmprestimo;
	private String DataDevolucao;
	private String CodigoExemplar;
	private String AssociadoProntuario;
		
	private String tableName = "EMPRESTIMO";
	private String fields	 = "id, data_emp, data_dev, fkExemplar_Id_Exemplar, fkAssociado_Prontuario";
	private String keyField  = "id";
	
	private DBQuery dbQuery = null;
	
	public Emprestimo() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public Emprestimo(String Id, String DataEmprestimo, String DataDevolucao, String CodigoExemplar, String Tipo) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setId(Id);
		this.setDataEmprestimo(DataEmprestimo);
		this.setDataDevolucao(DataDevolucao);
		this.setCodigoExemplar(CodigoExemplar);
		this.setAssociadoProntuario(AssociadoProntuario);
	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getId(),
					this.getDataEmprestimo(),
					this.getDataDevolucao(),
					this.getCodigoExemplar(),
					this.getAssociadoProntuario()
			}
		);
	}
	
	public void save() {
			this.dbQuery.insert(this.toArray());
	}
	
	/*public boolean checkDataEmprestimo(String user, String DataDevolucao) {
		ResultSet rs = this.dbQuery.select(" DataEmprestimo='"+user+"' AND DataDevolucao='"+DataDevolucao+"' AND Tipo='S'");
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
		this.dbQuery.delete(this.getId());
		//this.setTipo("N");
		//return(this.dbQuery.update(this.toArray()));
	}
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
	
	
	
	public String getDataEmprestimo() {
		return DataEmprestimo;
	}
	public void setDataEmprestimo(String DataEmprestimo) {
		this.DataEmprestimo = DataEmprestimo;
	}
	public String getDataDevolucao() {
		return DataDevolucao;
	}
	public void setDataDevolucao(String DataDevolucao) {
		this.DataDevolucao = DataDevolucao;
	}
	public String getCodigoExemplar() {
		return CodigoExemplar;
	}
	public void setCodigoExemplar(String CodigoExemplar) {
		this.CodigoExemplar = CodigoExemplar;
	}
	public String getAssociadoProntuario() {
		return AssociadoProntuario;
	}
	public void setAssociadoProntuario(String AssociadoProntuario) {
		this.AssociadoProntuario = AssociadoProntuario;
	}
	
}
