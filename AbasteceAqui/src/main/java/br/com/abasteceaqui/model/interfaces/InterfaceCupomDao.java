package br.com.abasteceaqui.model.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceCupomDao<Cupom> extends InterfaceGenericaDAO<Cupom> {
	
	public Cupom buscarPorId(Integer id);

}