package br.com.abasteceaqui.model.controller;

import java.util.List;
import br.com.abasteceaqui.model.entidades.Venda;
import br.com.abasteceaqui.model.implementacao.VendaDaoImpl;

public class VendaController {

	private VendaDaoImpl vendaDaoImpl = null;

	public VendaController() {
		this.vendaDaoImpl = new VendaDaoImpl();
	}

	public void salvar(Venda venda) {
		vendaDaoImpl.salvar(venda);
	}

	public Venda buscarPorCodigo(Integer codigo) {
		return vendaDaoImpl.buscarPorCodigo(codigo);
	}

	public Venda buscarPorId(Integer id) {
		return vendaDaoImpl.buscarPorId(id);
	}

	public void alterar(Venda venda) {
		vendaDaoImpl.atualizar(venda);
	}

	public void deletar(Venda venda) {
		vendaDaoImpl.deletar(venda);
	}

	public List<Venda> listarVenda() {
		return vendaDaoImpl.listar();
	}

}
