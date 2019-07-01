package br.com.abasteceaqui.model.interfaces;

@SuppressWarnings("hiding")
public interface InterfacePostoDao<Posto> extends InterfaceGenericaDAO<Posto> {
	
	public Posto buscarPorCnpj(String cnpj);

}
