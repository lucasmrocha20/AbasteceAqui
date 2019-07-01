package br.com.abasteceaqui.model.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceFrentistaDao<Frentista> extends InterfaceGenericaDAO<Frentista> {
	
	public Frentista buscarPorCpf(String cpf);

}
