package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.interfaces.InterfaceFrentistaDao;

public class FrentistaDaoImpl implements InterfaceFrentistaDao<Frentista> {
	
	public void salvar(Frentista frentista) {
        PersistenciaDAO.getInstance().salvar(frentista);
    }

    public void atualizar(Frentista frentista) {
        PersistenciaDAO.getInstance().atualizar(frentista);
    }

    public Frentista buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaDAO.getInstance().listar("SELECT f FROM Frentista f WHERE f.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Frentista) lista.get(0);
        }
            return null;  
    }

    public void deletar(Frentista frentista) {
        PersistenciaDAO.getInstance().deletar(frentista);
    }

    @SuppressWarnings("unchecked")
	public List<Frentista> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT f FROM Frentista f");
    }
    
    public Frentista buscarPorCpf(String cpf) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaDAO.getInstance().listar("SELECT f FROM Frentista f WHERE f.cpf=" + cpf);
        
        if(!lista.isEmpty()) {
        	return (Frentista) lista.get(0);
        }
            return null;
    }
    
}

