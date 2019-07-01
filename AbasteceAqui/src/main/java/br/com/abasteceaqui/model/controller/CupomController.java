package br.com.abasteceaqui.model.controller;

import java.util.List;

import br.com.abasteceaqui.model.entidades.Cupom;
import br.com.abasteceaqui.model.implementacao.CupomDaoImpl;


public class CupomController {

	private CupomDaoImpl cupomDaoImpl = null;

	public CupomController() {
		this.cupomDaoImpl = new CupomDaoImpl();
	}

	public void salvar(Cupom cupom) {
		cupomDaoImpl.salvar(cupom);
	}

	public Cupom buscarPorCodigo(Integer codigo) {
		return cupomDaoImpl.buscarPorCodigo(codigo);
	}

	public Cupom buscarPorId(Integer id) {
		return cupomDaoImpl.buscarPorId(id);
	}

	public void alterar(Cupom cupom) {
		cupomDaoImpl.atualizar(cupom);
	}

	public void deletar(Cupom cupom) {
		cupomDaoImpl.deletar(cupom);
	}

	public List<Cupom> listarCupom() {
		return cupomDaoImpl.listar();
	}

}
