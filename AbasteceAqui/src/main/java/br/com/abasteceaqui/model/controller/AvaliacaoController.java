package br.com.abasteceaqui.model.controller;

import java.util.List;
import br.com.abasteceaqui.model.entidades.Avaliacao;
import br.com.abasteceaqui.model.implementacao.AvaliacaoDaoImpl;

public class AvaliacaoController {

	private AvaliacaoDaoImpl avaliacaoDaoImpl = null;

	public AvaliacaoController() {
		this.avaliacaoDaoImpl = new AvaliacaoDaoImpl();
	}

	public void salvar(Avaliacao avaliacao) {
		avaliacaoDaoImpl.salvar(avaliacao);
	}

	public Avaliacao buscarPorCodigo(Integer codigo) {
		return avaliacaoDaoImpl.buscarPorCodigo(codigo);
	}

	public Avaliacao buscarPorId(Integer id) {
		return avaliacaoDaoImpl.buscarPorId(id);
	}

	public void alterar(Avaliacao avaliacao) {
		avaliacaoDaoImpl.atualizar(avaliacao);
	}

	public void deletar(Avaliacao avaliacao) {
		avaliacaoDaoImpl.deletar(avaliacao);
	}

	public List<Avaliacao> listarAvaliacao() {
		return avaliacaoDaoImpl.listar();
	}

}
