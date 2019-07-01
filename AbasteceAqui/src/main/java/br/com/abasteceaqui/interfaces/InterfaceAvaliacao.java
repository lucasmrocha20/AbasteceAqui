package br.com.abasteceaqui.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceAvaliacao<Avaliacao> extends InterfaceGenericaDAO<Avaliacao> {
	
	public Avaliacao buscarPorId(Integer id);

}
