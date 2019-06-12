package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reserva {

	private String CodigoAcervo;
	private String Prontuario;
	private String NumeroReserva;
	private String DataRealizacao;
	private String DataReserva;
		
	private String tableName = "RESERVA";
	private String fields	 = "fk_Acervo_Codigo_Acervo, fk_Associado_Prontuario, Numero_Reserva, Data_Realizacao, Data_Reserva";
	private String keyField  = "Numero_Reserva";
	
	private DBQuery dbQuery = null;
	
	public Reserva() {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
	}
	
	public Reserva(String CodigoAcervo, String Prontuario, String NumeroReserva, String DataRealizacao, String DataReserva, String EmprestimoTitulo) {
		this.dbQuery = new DBQuery(this.tableName, this.fields, this.keyField);
		this.setCodigoAcervo(CodigoAcervo);
		this.setProntuario(Prontuario);
		this.setNumeroReserva(NumeroReserva);
		this.setDataRealizacao(DataRealizacao);
		this.setDataReserva(DataReserva);
	}
	
	public ResultSet select(String where) {
		return(this.dbQuery.select(where));
	}
	
	private String[] toArray() {
		return(
			new String[]{
					this.getCodigoAcervo(),
					this.getProntuario(),
					this.getNumeroReserva(),
					this.getDataRealizacao(),
					this.getDataReserva()
					
			}
		);
	}
	
	public void save() {
			this.dbQuery.insert(this.toArray());
	}
	
	/*public boolean checkProntuario(String user, String NumeroReserva) {
		ResultSet rs = this.dbQuery.select(" Prontuario='"+user+"' AND NumeroReserva='"+NumeroReserva+"' AND Tipo='S'");
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
		this.dbQuery.delete(this.getCodigoAcervo());
		//this.setTipo("N");
		//return(this.dbQuery.update(this.toArray()));
	}
	public String getCodigoAcervo() {
		return CodigoAcervo;
	}
	public void setCodigoAcervo(String CodigoAcervo) {
		this.CodigoAcervo = CodigoAcervo;
	}
	
	
	
	public String getProntuario() {
		return Prontuario;
	}
	public void setProntuario(String Prontuario) {
		this.Prontuario = Prontuario;
	}
	public String getNumeroReserva() {
		return NumeroReserva;
	}
	public void setNumeroReserva(String NumeroReserva) {
		this.NumeroReserva = NumeroReserva;
	}
	public String getDataRealizacao() {
		return DataRealizacao;
	}
	public void setDataRealizacao(String DataRealizacao) {
		this.DataRealizacao = DataRealizacao;
	}
	public String getDataReserva() {
		return DataReserva;
	}
	public void setDataReserva(String DataReserva) {
		this.DataReserva = DataReserva;
	}
	
	
}
