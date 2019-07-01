package br.com.abasteceaqui.util;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = construirSessionFactory();

    private static SessionFactory construirSessionFactory() {
        if(sessionFactory == null) {
            try {
                Configuration configuracao = new Configuration().configure();
                StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder()
                    .applySettings(configuracao.getProperties());
                StandardServiceRegistry servico = registradorServico.build();
                return configuracao.buildSessionFactory(servico);
            } catch(HibernateException e) {
                System.err.println("Erro na constricao do objeto SessionFactory. Erro: " + e);
                throw new ExceptionInInitializerError(e);
            }
        } else {
            return sessionFactory;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
