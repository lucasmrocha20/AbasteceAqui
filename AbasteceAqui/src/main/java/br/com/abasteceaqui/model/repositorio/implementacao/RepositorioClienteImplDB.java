package br.com.abasteceaqui.model.repositorio.implementacao;

import java.util.List;

import br.com.abasteceaqui.dao.PersistenciaGenericaDAO;
import br.com.abasteceaqui.interfaces.InterfaceCliente;
import br.com.abasteceaqui.model.entidades.Cliente;

public class RepositorioClienteImplDB implements InterfaceCliente<Cliente> {

	public void salvar(Cliente cliente) {
        PersistenciaGenericaDAO.getInstance().salvar(cliente);
    }

    public void atualizar(Cliente cliente) {
        PersistenciaGenericaDAO.getInstance().atualizar(cliente);
    }

    public Cliente buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Cliente) lista.get(0);
        }
            return null;  
    }

    public void deletar(Cliente cliente) {
        PersistenciaGenericaDAO.getInstance().deletar(cliente);
    }

    @SuppressWarnings("unchecked")
	public List<Cliente> listar() {
        return PersistenciaGenericaDAO.getInstance().listar("SELECT c FROM Cliente c");
    }
    
    public Cliente buscarPorCnpj(String cnpj) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaGenericaDAO.getInstance().listar("SELECT c FROM Cliente c WHERE c.cnpj=" + cnpj);
        
        if(!lista.isEmpty()) {
        	return (Cliente) lista.get(0);
        }
            return null;
    }
	    
}
