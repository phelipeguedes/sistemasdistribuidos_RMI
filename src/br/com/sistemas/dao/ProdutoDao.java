package br.com.sistemas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sistemas.models.Produto;

public class ProdutoDao {
	
	public static int salvar(Produto produto){
		int iRet = -1;
		try {
			Connection conexao = ConexaoDB.getInstance().getConnection();
			String sql = "INSERT INTO produtos(nome_produto, valor_produto, categoria) values (?, ?, ?)";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, produto.getId_produto());
			pst.setString(2, produto.getNomeProduto());
			pst.setDouble(3, produto.getValorProduto());
			pst.setString(4, produto.getCategoria());
			
			iRet = pst.executeUpdate();
			pst.close();
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		
		return iRet;
	}
	
	public static int alterar(Produto produto){
		int iRet = -1;
		try {
			Connection conexao = ConexaoDB.getInstance().getConnection();
			String sql = "UPDATE produtos set nome_produto = ?, valor_produto = ?, categoria = ? WHERE id_produto = ?";
			PreparedStatement pst = conexao.prepareStatement(sql);		
			pst.setString(1, produto.getNomeProduto());
			pst.setDouble(2, produto.getValorProduto());
			pst.setString(3, produto.getCategoria());
			pst.setInt(4, produto.getId_produto());
			
			iRet = pst.executeUpdate();
			pst.close();
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		
		return iRet;
	}
	
	public static int deletar(Produto produto){
		int iRet = -1;
		try {
			Connection conexao = ConexaoDB.getInstance().getConnection();
			String sql = "DELETE FROM produtos where id_produto = ?";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, produto.getId_produto());
			
			iRet = pst.executeUpdate();
			pst.close();
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return iRet;
	}
	
	public static ArrayList pesquisarProduto(String nomeProduto){
		ArrayList al = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM produtos where nome_produto = like (?) ORDER BY id_produto";
			Connection conexao = ConexaoDB.getInstance().getConnection();
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeProduto);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Produto p = new Produto();
				p.setId_produto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nome_produto"));
				p.setValorProduto(rs.getLong(3));
				p.setCategoria(rs.getString("categoria"));
				al.add(p);
			}
			
			pst.close();			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return al;
	}
}
