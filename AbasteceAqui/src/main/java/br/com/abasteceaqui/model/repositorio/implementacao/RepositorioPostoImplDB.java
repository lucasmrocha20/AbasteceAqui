package br.com.abasteceaqui.model.repositorio.implementacao;

import java.util.List;

import br.com.abasteceaqui.dao.PersistenciaGenericaDAO;
import br.com.abasteceaqui.interfaces.InterfacePosto;
import br.com.abasteceaqui.model.entidades.Posto;

public class RepositorioPostoImplDB implements InterfacePosto<Posto> {

	public void salvar(Posto posto) {
		PersistenciaGenericaDAO.getInstance().salvar(posto);
	}

	public void atualizar(Posto posto) {
		PersistenciaGenericaDAO.getInstance().atualizar(posto);
	}

	public Posto buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT p FROM Posto p WHERE p.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Posto) lista.get(0);
		}
		return null;
	}

	public void deletar(Posto posto) {
		PersistenciaGenericaDAO.getInstance().deletar(posto);
	}

	@SuppressWarnings("unchecked")
	public List<Posto> listar() {
		return PersistenciaGenericaDAO.getInstance().listar("SELECT p FROM Posto p");
	}

	public Posto buscarPorCnpj(String cnpj) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT p FROM Usuario p WHERE p.cnpj=" + cnpj);

		if (!lista.isEmpty()) {
			return (Posto) lista.get(0);
		}
		return null;
	}

}
