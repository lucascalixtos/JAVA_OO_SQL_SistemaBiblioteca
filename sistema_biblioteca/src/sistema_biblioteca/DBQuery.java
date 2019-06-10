package sistema_biblioteca;


import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
	
	private DBConnection dbConnection = null;	
	private String tableName;
	private String fields;
	private String keyField;
	
	public DBQuery() {
		this.dbConnection = new DBConnection();
	}
	
	public DBQuery(String tableName, String fields, String keyField) {
		this.dbConnection = new DBConnection();
		this.setTableName(tableName);
		this.setFields(fields);
		this.setKeyField(keyField);
	}
	
	
	public ResultSet select(String where) {
		if (this.tableName.isEmpty() || 
			this.fields.isEmpty()){
			System.out.print("Os dados desta classe não foram informados!");
			return(null);
		}
			
		String sql = ""+ 
					 " SELECT "+
					 this.getFields() +
					 " FROM "+
					 this.getTableName() +
					 (where.isEmpty()?"":(" WHERE "+where));
		System.out.println(sql); // esta aqui por questões didáticas
		return (this.executeQuery(sql));
	}
	
	public ResultSet selectId(String where) {
		if (this.tableName.isEmpty() || 
			this.fields.isEmpty()){
			System.out.print("Os dados desta classe não foram informados!");
			return(null);
		}
			
		String sql = ""+ 
					 " SELECT "+
					 " FROM "+
					 this.getTableName() +
					 (where.isEmpty()?"":(" WHERE "+where));
		System.out.println(sql); // esta aqui por questões didáticas
		return (this.executeQuery(sql));
	}
	
	public ResultSet select() {
		return (this.select(""));
	}

	public int insert(String[] values) {	
		String sql = " INSERT INTO "+ 
					 this.getTableName() +
					 " ( "+this.getFields()+") "+
					 "\n VALUES ( ";
		
		for (int i =0; i < values.length; i++){
			sql += "'"+values[i]+"'";
			sql += ((i==values.length-1)?" ) ":", ");
		}
		System.out.println(sql);
		return(this.executeUpdate(sql));
	}
	
	public int update(String[] values) {
		String sql = " UPDATE "+ this.getTableName() + " SET ";
		String[] fieldsName = this.fields.split(",");
		int keyFieldIndex = this.getKeyFieldIndex();
		
		for(int i = 0; i< fieldsName.length; i++){
			if (i != keyFieldIndex){
				sql += "\n\t"+fieldsName[i]+" = '"+ values[i] +"'"+
						     ( (i < fieldsName.length-1) ? "," : "" );
			}
		}
		
		sql += "\n WHERE "+ fieldsName[keyFieldIndex]+" = '"+ values[keyFieldIndex]+"'";
		System.out.println(sql);
		return(this.executeUpdate(sql));				
	}
	
	public int updateEmprestimo(String KeyFieldValue, int values) {
		String sql = " UPDATE "+ this.getTableName() + " SET ";
		String fields = "Quantidade = " + values;
		int keyFieldIndex = this.getKeyFieldIndex();
		
		sql += fields + "\n WHERE "+ "Codigo_Exemplar" +" = '"+ KeyFieldValue +"'";
		System.out.println(sql);
		return(this.executeUpdate(sql));				
	}
	
	public int delete(String  keyValue) {
		String sql = " DELETE FROM " + this.tableName +
					 " WHERE "+ keyField +" = '"+keyValue+"'";
		System.out.println(sql);
		return(this.executeUpdate(sql));
	}
	
	private int getKeyFieldIndex(){
		String[] fieldsName = this.fields.split(",");
		for(int i = 0; i< fieldsName.length; i++){
			if (fieldsName[i].equals(this.keyField)){
				return(i);
			}
		}
		return(0);
	}
	
	public ResultSet executeQuery(String sql) {
		try {
			Statement stmt = this.dbConnection.getStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return(null);
	}
	
	public int executeUpdate(String sql) {
		try {
			Statement stmt = this.dbConnection.getStatement();
			int linesUpdated = stmt.executeUpdate(sql);
			return(linesUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return(0);
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getKeyField() {
		return keyField;
	}

	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	
	
}
