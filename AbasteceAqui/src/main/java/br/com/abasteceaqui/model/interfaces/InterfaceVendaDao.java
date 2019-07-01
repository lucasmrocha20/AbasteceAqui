package br.com.abasteceaqui.model.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceVendaDao<Venda> extends InterfaceGenericaDAO<Venda> {
	
	public Venda buscarPorId(Integer id);

}