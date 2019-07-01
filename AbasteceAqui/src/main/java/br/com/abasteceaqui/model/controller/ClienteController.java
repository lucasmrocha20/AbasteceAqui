package br.com.abasteceaqui.model.controller;

import java.util.List;

import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.implementacao.ClienteDaoImpl;
import br.com.abasteceaqui.util.Excecoes;

public class ClienteController {

	private ClienteDaoImpl clienteDaoImpl = null;

	public ClienteController() {
		this.clienteDaoImpl = new ClienteDaoImpl();
	}

	/*
	 * - Validação no model
	 * 
	 * - tratamento de exceção no controller
	 * 
	 * - dados no DAO
	 * 
	 * - controller chama model e model chama dao.
	 */
	public void salvar(Cliente cliente){
		
		try{
			if (cliente != null) {
		clienteDaoImpl.salvar(cliente);
			}
		}catch(Excecoes e){
			System.out.println(e.getMessage());
		}
	}

	public Cliente buscarPorCodigo(Integer codigo) {
		return clienteDaoImpl.buscarPorCodigo(codigo);
	}

	public Cliente buscarPorCnpj(Integer codigo) {
		return clienteDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar(Cliente cliente) {
		clienteDaoImpl.atualizar(cliente);
	}

	public void deletar(Cliente cliente) {
		clienteDaoImpl.deletar(cliente);
	}

	public List<Cliente> listarCliente() {
		return clienteDaoImpl.listar();
	}

}
