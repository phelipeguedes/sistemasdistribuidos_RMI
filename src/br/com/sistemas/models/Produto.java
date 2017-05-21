package br.com.sistemas.models;

import java.io.Serializable;

public class Produto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id_produto;
	private String nomeProduto;
	private double valorProduto;
	private String categoria;
	
	public Produto(){
	}
	
	public Produto(int id_produto, String nomeProduto, double valorProduto, String categoria){
		this.setId_produto(id_produto);
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id_produto + " - " + nomeProduto + " - " + categoria;
	}
}
