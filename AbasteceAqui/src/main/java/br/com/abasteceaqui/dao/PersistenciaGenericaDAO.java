package br.com.abasteceaqui.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.abasteceaqui.util.HibernateUtil;

public class PersistenciaGenericaDAO {
	private final SessionFactory sessionFactory;
    private static PersistenciaGenericaDAO instance = null;
    
    public static PersistenciaGenericaDAO getInstance() {
        if(instance == null) {
            instance = new PersistenciaGenericaDAO();
        }
        return instance;
    }
    
    private PersistenciaGenericaDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
       
    public void salvar(Object o) {
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.save(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
        
    }

    @SuppressWarnings("rawtypes")
	public List listar(String sql) {
        Session session = this.sessionFactory.openSession();
        List lista = null;
        
        try {
            Query consulta = session.createQuery(sql);
            lista = (List) consulta.list();
        } catch(RuntimeException ex) {
            throw ex;
        } finally {
                session.close();
        }
        
        return lista;
        
    }

    public void atualizar(Object o) {
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.update(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
        
    }

    public void deletar(Object o) {
        Session session = this.sessionFactory.openSession();
        Transaction transacao = null;
        
        try {
            transacao = session.beginTransaction();
            session.delete(o);
            transacao.commit();
        } catch(RuntimeException ex) {
            if(transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            session.close();
        }
        
    }
    
}
