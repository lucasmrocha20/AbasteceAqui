package br.com.abasteceaqui.interfaces;

@SuppressWarnings("hiding")
public interface InterfacePosto<Posto> extends InterfaceGenericaDAO<Posto> {
	
	public Posto buscarPorCnpj(String cnpj);

}
