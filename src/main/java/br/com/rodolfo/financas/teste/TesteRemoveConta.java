package br.com.rodolfo.financas.teste;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.util.JPAUtil;

/**
 * TesteRemoveConta
 */
public class TesteRemoveConta {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = em.find(Conta.class, 8);

        em.getTransaction().begin();
        em.remove(conta);
        em.getTransaction().commit();

        em.close();

        //Após a remoção do objeto do banco ele ainda se encontra na memória no estado REMOVED. Podemos inseri-lo no banco outra vez passando do estado REMOVED para o estado MANAGED através do método MERGE mas a sua chave não permanecerá a mesma, como a 8 do exemplo acima e será atribuída uma nova chave, ou seja, é um novo objeto sendo persistido no banco.

        EntityManager em2 = new JPAUtil().getEntityManager();

        conta.setBanco("111 - BANCO INTER");

        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();

        em2.close();

    }
}