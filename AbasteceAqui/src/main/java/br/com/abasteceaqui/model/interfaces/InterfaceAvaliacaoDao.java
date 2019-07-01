package br.com.abasteceaqui.model.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceAvaliacaoDao<Avaliacao> extends InterfaceGenericaDAO<Avaliacao> {
	
	public Avaliacao buscarPorId(Integer id);

}