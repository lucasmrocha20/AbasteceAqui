package br.com.abasteceaqui.model.repositorio.implementacao;

import java.util.List;

import br.com.abasteceaqui.dao.PersistenciaGenericaDAO;
import br.com.abasteceaqui.interfaces.InterfaceVenda;
import br.com.abasteceaqui.model.entidades.Venda;

public class RepositorioVendaImplDB implements InterfaceVenda<Venda> {
	
	public void salvar(Venda venda) {
        PersistenciaGenericaDAO.getInstance().salvar(venda);
    }

    public void atualizar(Venda venda) {
        PersistenciaGenericaDAO.getInstance().atualizar(venda);
    }

    public Venda buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT v FROM Venda v WHERE v.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Venda) lista.get(0);
        }
            return null;  
    }

    public void deletar(Venda venda) {
        PersistenciaGenericaDAO.getInstance().deletar(venda);
    }

    @SuppressWarnings("unchecked")
	public List<Venda> listar() {
        return PersistenciaGenericaDAO.getInstance().listar("SELECT v FROM Venda v");
    }
    
    public Venda buscarPorId(Integer id) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaGenericaDAO.getInstance().listar("SELECT v FROM Venda v WHERE v.id=" + id);
        
        if(!lista.isEmpty()) {
        	return (Venda) lista.get(0);
        }
            return null;
    
	}
    
}

