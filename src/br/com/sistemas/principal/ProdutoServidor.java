package br.com.sistemas.principal;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.com.sistemas.dao.ProdutoObjeto;

public class ProdutoServidor {
	
	public static void main(String[] args) {
		
		try {
			Registry registro = LocateRegistry.createRegistry(1099);
			
			//instanciando objeto servidor
			ProdutoObjeto prod = new ProdutoObjeto();
			
			//registrando objeto servidor
			registro.rebind("Produto", prod);
			System.out.println("O servidor está funcionando.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
