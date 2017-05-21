package br.com.sistemas.dao;

import java.sql.*;

public class ConexaoDB {
	
	private static ConexaoDB instancia = null;
	private Connection conexao = null;
	
	public ConexaoDB(){
		conexao = getMysqlConnection();
	}
	
	public static synchronized ConexaoDB getInstance(){
		if(instancia == null){
			instancia = new ConexaoDB();
		}
		return instancia;
	}
	
	public Connection getConnection(){
		return conexao;
	}
	
	private static Connection getMysqlConnection(){
		Connection conexao = null;
		String url = "jdbc:mysql://localhost/cadastro_rmi";
		String usuario = "root";
		String senha = "";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexao = DriverManager.getConnection(url, usuario, senha); 			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conexao;
	}
}
