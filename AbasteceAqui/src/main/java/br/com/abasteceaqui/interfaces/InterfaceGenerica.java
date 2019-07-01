package br.com.abasteceaqui.interfaces;

import java.util.List;

public interface InterfaceGenerica<T> {
	
	public void salvar(T obj);
	public void atualizar(T obj);
	public void deletar(T obj);
	public T buscarPorCodigo(Integer id);
	public List<T> listar();

}
