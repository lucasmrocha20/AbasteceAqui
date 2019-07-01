package br.com.abasteceaqui.model.controller;

import java.util.List;
import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.implementacao.UsuarioDaoImpl;

public class UsuarioController {

	private UsuarioDaoImpl usuarioDaoImpl = null;

	public UsuarioController() {
		this.usuarioDaoImpl = new UsuarioDaoImpl();
	}

	public void salvar(Usuario usuario) {
		usuarioDaoImpl.salvar(usuario);
	}

	public Usuario buscarPorCodigo(Integer codigo) {
		return usuarioDaoImpl.buscarPorCodigo(codigo);
	}

	public Usuario buscarPorCpf(Integer codigo) {
		return usuarioDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar(Usuario usuario) {
		usuarioDaoImpl.atualizar(usuario);
	}

	public void deletar(Usuario usuario) {
		usuarioDaoImpl.deletar(usuario);
	}

	public List<Usuario> listarUsuario() {
		return usuarioDaoImpl.listar();
	}

}
