package br.com.abasteceaqui.model.controller;

import java.util.List;
import br.com.abasteceaqui.model.entidades.Posto;
import br.com.abasteceaqui.model.implementacao.PostoDaoImpl;

public class PostoController {

	private PostoDaoImpl postoDaoImpl = null;

	public PostoController() {
		this.postoDaoImpl = new PostoDaoImpl();
	}

	public void salvar(Posto posto) {
		postoDaoImpl.salvar(posto);
	}

	public Posto buscarPorCodigo(Integer codigo) {
		return postoDaoImpl.buscarPorCodigo(codigo);
	}

	public Posto buscarPorCnpj(Integer codigo) {
		return postoDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar(Posto posto) {
		postoDaoImpl.atualizar(posto);
	}

	public void deletar(Posto posto) {
		postoDaoImpl.deletar(posto);
	}

	public List<Posto> listarPosto() {
		return postoDaoImpl.listar();
	}

}
