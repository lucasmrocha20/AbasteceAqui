package br.com.abasteceaqui.model.interfaces;

import java.util.List;

import br.com.abasteceaqui.util.Excecoes;

public interface InterfaceGenericaDAO<T> {
	
	public void salvar(T obj) throws Excecoes;
	public void atualizar(T obj);
	public void deletar(T obj);
	public T buscarPorCodigo(Integer id);
	public List<T> listar();

}

