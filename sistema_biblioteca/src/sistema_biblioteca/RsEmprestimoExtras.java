package sistema_biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;

public class RsEmprestimoExtras{
	
	private ResultSet rs = null;
	private int countRows= 0;
	private int countCols= 0;
	private JTable jTable= null;

	public RsEmprestimoExtras( ResultSet rs ) {
		this.rs = rs;
	
			try {
				this.countCols = rs.getMetaData().getColumnCount();
				this.rs.last();
				this.countRows = rs.getRow();
				this.rs.beforeFirst();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public String[] columnsLabelToArray() {
		String[] colunas = new String[]{"ID", "Titulo", "Empréstimo", "Prazo de Devolução", "Prontuário"};
		return(colunas);
	}
	
	public Object[][] dataToArray() {
		int qtdLinhas = this.getCountRows();
		int qtdColunas = this.getCountCols();
		
		String[][] dadosColunas = new String[qtdLinhas][qtdColunas];
		int lin =0;
		try {
			while(rs.next()){
				for(int col=0; col< this.getCountCols(); col++){
					dadosColunas[lin][col] = rs.getString(col+1);
				}
				lin++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (dadosColunas);
	}
	
	public int getCountRows() {
		return countRows;
	}

	public void setCountRows(int countRows) {
		this.countRows = countRows;
	}

	public int getCountCols() {
		return countCols;
	}

	public void setCountCols(int countCols) {
		this.countCols = countCols;
	}

	public JTable getjTable() {
		this.jTable =  new JTable(this.dataToArray(), this.columnsLabelToArray());
		return jTable;
	}
}
