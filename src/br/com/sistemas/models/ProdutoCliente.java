package br.com.sistemas.models;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import br.com.sistemas.interfaces.ProdutoRemoto;

public class ProdutoCliente {
	
	public static void main(String[] args) {
		
		try {
			Registry registro = LocateRegistry.getRegistry("127.0.0.1");
			ProdutoRemoto pr = (ProdutoRemoto) registro.lookup("Produto");
			
			Produto p1 = new Produto(1, "Notebook Dell", 2499.99, "Informática");
			Produto p2 = new Produto(2, "Guitarra ESP-LTD", 3700.00, "Instrumentos Musicais");
			
			// salvando produtos 
			System.out.println("Salvando produtos...");
			pr.salvar(p1);
			pr.salvar(p2);
			
			//atualizando produto
			System.out.println("Alterando informações do produto...");
			Produto notebookDell = new Produto(3, "Notebook Samsung", 2199.99, "Informática");
			int produtoRemoto = pr.alterar(notebookDell);
			
			//deletando produto
			System.out.println("Deletando registros do produto...");
			pr.deletar(p1);
			
			//exibindo informações de um produto
			System.out.println("Buscar produto (notebook): ");
			ArrayList produtos = new ArrayList<>();
			produtos = pr.pesquisarProduto("Notebook");
			for (Produto p : produtos) {
				System.out.println(p.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
