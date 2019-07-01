package br.com.abasteceaqui.interfaces;

import br.com.abasteceaqui.interfaces.InterfaceGenericaDAO;

@SuppressWarnings("hiding")
public interface InterfaceUsuario<Usuario> extends InterfaceGenericaDAO<Usuario> {
	
	public Usuario buscarPorCpf(String cpf);

}
