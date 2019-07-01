package br.com.abasteceaqui.model.controller;

import java.util.List;
import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.implementacao.FrentistaDaoImpl;

public class FrentistaController {

	private FrentistaDaoImpl frentistaDaoImpl = null;

	public FrentistaController() {
		this.frentistaDaoImpl = new FrentistaDaoImpl();
	}

	public void salvar(Frentista frentista) {
		frentistaDaoImpl.salvar(frentista);
	}

	public Frentista buscarPorCodigo(Integer codigo) {
		return frentistaDaoImpl.buscarPorCodigo(codigo);
	}

	public Frentista buscarPorCpf(Integer codigo) {
		return frentistaDaoImpl.buscarPorCodigo(codigo);
	}

	public void alterar(Frentista frentista) {
		frentistaDaoImpl.atualizar(frentista);
	}

	public void deletar(Frentista frentista) {
		frentistaDaoImpl.deletar(frentista);
	}

	public List<Frentista> listarFrentista() {
		return frentistaDaoImpl.listar();
	}

}
