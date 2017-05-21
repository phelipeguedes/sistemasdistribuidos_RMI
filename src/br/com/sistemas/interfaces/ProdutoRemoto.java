package br.com.sistemas.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import br.com.sistemas.models.Produto;

public interface ProdutoRemoto extends Remote{
	
	public int salvar(Produto produto) throws RemoteException;
	public int alterar(Produto produto) throws RemoteException;
	public int deletar(Produto produto) throws RemoteException;
	public ArrayList<Produto> pesquisarProduto(String criteria) throws RemoteException;
}
