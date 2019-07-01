package br.com.abasteceaqui.interfaces;

import br.com.abasteceaqui.interfaces.InterfaceGenericaDAO;
import br.com.abasteceaqui.model.entidades.Cliente;

@SuppressWarnings("hiding")
public interface InterfaceCliente<Cliente> extends InterfaceGenericaDAO<Cliente> {
	
	public Cliente buscarPorCnpj(String cnpjCliente);

}
