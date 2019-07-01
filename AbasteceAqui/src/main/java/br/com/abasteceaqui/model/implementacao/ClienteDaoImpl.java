package br.com.abasteceaqui.model.implementacao;

import java.util.List;


import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.interfaces.InterfaceClienteDao;
import br.com.abasteceaqui.util.Excecoes;

public class ClienteDaoImpl implements InterfaceClienteDao<Cliente> {

	public void salvar(Cliente cliente) throws Excecoes{
		if(cliente != null){
			
        PersistenciaDAO.getInstance().salvar(cliente);
		}else{
			throw new Excecoes("Error ao Salvar");
		}
	}

    public void atualizar(Cliente cliente) {
        PersistenciaDAO.getInstance().atualizar(cliente);
    }

    public Cliente buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Cliente) lista.get(0);
        }
            return null;  
    }

    public void deletar(Cliente cliente) {
        PersistenciaDAO.getInstance().deletar(cliente);
    }

    @SuppressWarnings("unchecked")
	public List<Cliente> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c");
    }
    
    public Cliente buscarPorCnpj(String cnpj) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.cnpj=" + cnpj);
        
        if(!lista.isEmpty()) {
        	return (Cliente) lista.get(0);
        }
            return null;
    }
	    
}
