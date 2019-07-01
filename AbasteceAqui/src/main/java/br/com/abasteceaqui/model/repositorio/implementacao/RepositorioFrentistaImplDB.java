package br.com.abasteceaqui.model.repositorio.implementacao;

import java.util.List;

import br.com.abasteceaqui.dao.PersistenciaGenericaDAO;
import br.com.abasteceaqui.interfaces.InterfaceFrentista;
import br.com.abasteceaqui.model.entidades.Frentista;

public class RepositorioFrentistaImplDB implements InterfaceFrentista<Frentista> {
	
	public void salvar(Frentista frentista) {
        PersistenciaGenericaDAO.getInstance().salvar(frentista);
    }

    public void atualizar(Frentista frentista) {
        PersistenciaGenericaDAO.getInstance().atualizar(frentista);
    }

    public Frentista buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT f FROM Frentista f WHERE f.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Frentista) lista.get(0);
        }
            return null;  
    }

    public void deletar(Frentista frentista) {
        PersistenciaGenericaDAO.getInstance().deletar(frentista);
    }

    @SuppressWarnings("unchecked")
	public List<Frentista> listar() {
        return PersistenciaGenericaDAO.getInstance().listar("SELECT f FROM Frentista f");
    }
    
    public Frentista buscarPorCpf(String cpf) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaGenericaDAO.getInstance().listar("SELECT f FROM Usuario f WHERE f.cpf=" + cpf);
        
        if(!lista.isEmpty()) {
        	return (Frentista) lista.get(0);
        }
            return null;
    }
    
}

