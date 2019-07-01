package br.com.abasteceaqui.interfaces;

@SuppressWarnings("hiding")
public interface InterfaceFrentista<Frentista> extends InterfaceGenericaDAO<Frentista> {
	
	public Frentista buscarPorCpf(String cpf);

}
