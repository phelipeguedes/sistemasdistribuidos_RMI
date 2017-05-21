package br.com.sistemas.dao;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import br.com.sistemas.interfaces.ProdutoRemoto;
import br.com.sistemas.models.Produto;

public class ProdutoObjeto extends UnicastRemoteObject implements ProdutoRemoto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoObjeto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int salvar(Produto produto) throws RemoteException {
		try {
			System.out.println("Salvo de: " + getClientHost());
		} catch (ServerNotActiveException s) {
			s.printStackTrace();
		}
		return ProdutoDao.salvar(produto);
	}

	@Override
	public int alterar(Produto produto) throws RemoteException {
		try {
			System.out.println("Alterado de: " + getClientHost());
		} catch (ServerNotActiveException s) {
			s.printStackTrace();
		}
		return ProdutoDao.alterar(produto);
	}

	@Override
	public int deletar(Produto produto) throws RemoteException {
		try {
			System.out.println("Deletado de: " + getClientHost());
		} catch (ServerNotActiveException s) {
			s.printStackTrace();
		}
		return ProdutoDao.deletar(produto);
	}

	@Override
	public ArrayList<Produto> pesquisarProduto(String criteria) throws RemoteException {
		try {
			System.out.println("Encontrado de: " + getClientHost());
		} catch (ServerNotActiveException s) {
			s.printStackTrace();
		}
		return ProdutoDao.pesquisarProduto(criteria);
	}
	
	
	
	
}
