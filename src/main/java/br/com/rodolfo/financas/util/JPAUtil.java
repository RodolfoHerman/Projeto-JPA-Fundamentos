package br.com.rodolfo.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPAUtil
 * Manter o código de criação do EntityManager isolado em uma classe especialista
 */
public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");

    public EntityManager getEntityManager() {
        
        return emf.createEntityManager();
    }

}