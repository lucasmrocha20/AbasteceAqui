package br.com.abasteceaqui.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceCupom<Cupom> extends InterfaceGenericaDAO<Cupom> {
	
	public Cupom buscarPorId(Integer id);

}