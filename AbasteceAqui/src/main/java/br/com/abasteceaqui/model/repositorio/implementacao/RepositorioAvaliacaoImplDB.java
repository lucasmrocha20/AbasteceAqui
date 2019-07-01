package br.com.abasteceaqui.model.repositorio.implementacao;

import java.util.List;

import br.com.abasteceaqui.dao.PersistenciaGenericaDAO;
import br.com.abasteceaqui.interfaces.InterfaceAvaliacao;
import br.com.abasteceaqui.model.entidades.Avaliacao;

public class RepositorioAvaliacaoImplDB implements InterfaceAvaliacao<Avaliacao> {

	public void salvar(Avaliacao avaliacao) {
		PersistenciaGenericaDAO.getInstance().salvar(avaliacao);
	}

	public void atualizar(Avaliacao avaliacao) {
		PersistenciaGenericaDAO.getInstance().atualizar(avaliacao);
	}

	public Avaliacao buscarPorCodigo(Integer codigo) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT a FROM Avaliacao a WHERE u.id=" + codigo);

		if (!lista.isEmpty()) {
			return (Avaliacao) lista.get(0);
		}
		return null;
	}

	public void deletar(Avaliacao avaliacao) {
		PersistenciaGenericaDAO.getInstance().deletar(avaliacao);
	}

	@SuppressWarnings("unchecked")
	public List<Avaliacao> listar() {
		return PersistenciaGenericaDAO.getInstance().listar("SELECT a FROM Avaliacao a");
	}

	public Avaliacao buscarPorId(Integer id) {
		@SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT a FROM Avaliacao a WHERE a.id=" + id);

		if (!lista.isEmpty()) {
			return (Avaliacao) lista.get(0);
		}
		return null;
	}

}
