package br.com.abasteceaqui.model.interfaces;

import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.interfaces.InterfaceGenericaDAO;

@SuppressWarnings("hiding")
public interface InterfaceClienteDao<Cliente> extends InterfaceGenericaDAO<Cliente> {
	
	public Cliente buscarPorCnpj(String cnpjCliente);

}
