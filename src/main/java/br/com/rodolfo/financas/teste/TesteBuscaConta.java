package br.com.rodolfo.financas.teste;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.util.JPAUtil;

/**
 * TesteBuscaConta
 */
public class TesteBuscaConta {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();

        //Neste momento o JPA sincroniza os dados vindo do BANCO com o OBJETO 'conta' e deixa o objeto no estado MANAGED. Neste estado qualquer alteração realizada no obejeto reflitirá nos dados do banco ao fazermos um commit. (Será executado apenas um UPDATE pelo Hibernate caso tenha mudanças nos dados)
        Conta conta = em.find(Conta.class, 1);

        System.out.println(conta.getTitular());
        
        conta.setTitular("Joao");
        conta.setAgencia("1245");
        
        System.out.println(conta.getTitular());

        em.getTransaction().commit();
        
        em.close();

        //Quando o 'EntityManager' é fechado o objeto 'conta' passa para o estado DETACHED. Caso ocorra a necessidade de editar o objeto novamento é necessário um novo 'EntityManager'
        
        EntityManager em2 = new JPAUtil().getEntityManager();

        conta.setBanco("0001 - BANCO INTER");

        em2.getTransaction().begin();

        //Dará erro ao persistir o objeto pois ele se encontra no banco e já foi gerenciado anteriormente pelo JPA
        //em2.persist(conta);

        //Em vez de fazer o 'persist' para tornar o objeto MANAGED outra vez pelo JPA é necessário fazer o MERGE, assim o objeto volta para o estado MANAGED e o update é realizado
        em2.merge(conta);

        //Salvar as alterações
        em2.getTransaction().commit();

        em2.close();

    }
    
}