package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	
	//metodo para gerar a conex�o com banco de dados
	public static Connection getConexao() {
		if(conn == null) {
			try {
				//peguei as propriedades do banco de dados
				Properties prop = carregandoDados();
				
				//dburl=jdbc:mysql://localhost:3306/cursojdbc
				// o url serve para informa a porta da aplica��o, e qual o nome da database do banco de dados
				String url = prop.getProperty("dburl");
				
				// o principal para fazer uma conex�o � a classe Connection, e nesse caso ele � recebe o DriverManager para ajudar a conex�o
				// um depende do outro, o DriveManager � o envia as informa��es da conex�o para o Connection (" conn ") fazer a conex�o com banco de dados
				conn = DriverManager.getConnection(url, prop);
				
				
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
			
			
			
		}
		return conn;
	}
	
	public static void fecharConexao() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e ) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	// metodo para carregar os dados necessarios para fazer a conex�o java com o banco de dados MYsql
	// esses dados est�o em um arquivo feito chamado db.Properties
	private static Properties carregandoDados() {
		try(FileInputStream fi = new FileInputStream("db.properties")){
			Properties prop = new Properties();
			prop.load(fi);
			return prop;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	public static void fecharStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	public static void fecharResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
