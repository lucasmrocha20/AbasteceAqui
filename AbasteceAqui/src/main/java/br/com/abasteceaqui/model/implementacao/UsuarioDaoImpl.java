package br.com.abasteceaqui.model.implementacao;

import java.util.List;

import br.com.abasteceaqui.model.dao.PersistenciaDAO;
import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.interfaces.InterfaceUsuarioDao;

public class UsuarioDaoImpl implements InterfaceUsuarioDao<Usuario> {
	
	public void salvar(Usuario usuario) {
        PersistenciaDAO.getInstance().salvar(usuario);
    }

    public void atualizar(Usuario usuario) {
        PersistenciaDAO.getInstance().atualizar(usuario);
    }

    public Usuario buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaDAO.getInstance().listar("SELECT u FROM Usuario u WHERE u.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Usuario) lista.get(0);
        }
            return null;  
    }

    public void deletar(Usuario usuario) {
        PersistenciaDAO.getInstance().deletar(usuario);
    }

    @SuppressWarnings("unchecked")
	public List<Usuario> listar() {
        return PersistenciaDAO.getInstance().listar("SELECT u FROM Usuario u");
    }
    
    public Usuario buscarPorCpf(String cpf) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaDAO.getInstance().listar("SELECT u FROM Usuario u WHERE u.cpf=" + cpf);
        
        if(!lista.isEmpty()) {
        	return (Usuario) lista.get(0);
        }
            return null;
    }
    
}

