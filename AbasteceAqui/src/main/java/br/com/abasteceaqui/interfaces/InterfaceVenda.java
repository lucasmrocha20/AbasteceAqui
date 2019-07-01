package br.com.abasteceaqui.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceVenda<Venda> extends InterfaceGenericaDAO<Venda> {
	
	public Venda buscarPorId(Integer id);

}
