package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Venda;
import br.com.abasteceaqui.model.interfaces.InterfaceVendaDao;

public class VendaDaoImpl implements InterfaceVendaDao<Venda> {
	
	public void salvar(Venda venda) {
        PersistenciaDAO.getInstance().salvar(venda);
    }

    public void atualizar(Venda venda) {
        PersistenciaDAO.getInstance().atualizar(venda);
    }

    public Venda buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaDAO.getInstance().listar("SELECT v FROM Venda v WHERE v.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Venda) lista.get(0);
        }
            return null;  
    }

    public void deletar(Venda venda) {
        PersistenciaDAO.getInstance().deletar(venda);
    }

    @SuppressWarnings("unchecked")
	public List<Venda> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT v FROM Venda v");
    }
    
    public Venda buscarPorId(Integer id) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaDAO.getInstance().listar("SELECT v FROM Venda v WHERE v.id=" + id);
        
        if(!lista.isEmpty()) {
        	return (Venda) lista.get(0);
        }
            return null;
    }
    
}

