package br.com.abasteceaqui.model.repositorio.implementacao;

import java.util.List;

import br.com.abasteceaqui.dao.PersistenciaGenericaDAO;
import br.com.abasteceaqui.interfaces.InterfaceUsuario;
import br.com.abasteceaqui.model.entidades.Usuario;

public class RepositorioUsuarioImplDB implements InterfaceUsuario<Usuario> {
	
	public void salvar(Usuario usuario) {
        PersistenciaGenericaDAO.getInstance().salvar(usuario);
    }

    public void atualizar(Usuario usuario) {
        PersistenciaGenericaDAO.getInstance().atualizar(usuario);
    }

    public Usuario buscarPorCodigo(Integer codigo) {
        @SuppressWarnings("rawtypes")
		List lista = PersistenciaGenericaDAO.getInstance().listar("SELECT u FROM Usuario u WHERE u.id=" + codigo);
        
        if(!lista.isEmpty()) {
            return (Usuario) lista.get(0);
        }
            return null;  
    }

    public void deletar(Usuario usuario) {
        PersistenciaGenericaDAO.getInstance().deletar(usuario);
    }

    @SuppressWarnings("unchecked")
	public List<Usuario> listar() {
        return PersistenciaGenericaDAO.getInstance().listar("SELECT u FROM Usuario u");
    }
    
    public Usuario buscarPorCpf(String cpf) {
        @SuppressWarnings("rawtypes")
		List lista =  PersistenciaGenericaDAO.getInstance().listar("SELECT u FROM Usuario u WHERE u.cpf=" + cpf);
        
        if(!lista.isEmpty()) {
        	return (Usuario) lista.get(0);
        }
            return null;
    }
    
}

