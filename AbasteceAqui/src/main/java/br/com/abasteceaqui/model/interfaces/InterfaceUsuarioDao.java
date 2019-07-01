package br.com.abasteceaqui.model.interfaces;

import br.com.abasteceaqui.model.interfaces.InterfaceGenericaDAO;

@SuppressWarnings("hiding")
public interface InterfaceUsuarioDao<Usuario> extends InterfaceGenericaDAO<Usuario> {
	
	public Usuario buscarPorCpf(String cpf);

}
