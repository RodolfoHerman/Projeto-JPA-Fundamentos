package br.com.rodolfo.financas.util;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;

/**
 * PopulaConta
 */
public class PopulaConta {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        Conta conta3 = new Conta();
        Conta conta4 = new Conta();
        Conta conta5 = new Conta();

        conta1.setBanco("001 - BANCO DO BRASIL");
        conta1.setNumero("16987-8");
        conta1.setAgencia("6543");
        conta1.setTitular("Maria dos Santos");

        conta2.setBanco("237 - BANCO DO BRADESCO");
        conta2.setNumero("23213-1");
        conta2.setAgencia("1234");
        conta2.setTitular("Paulo Roberto Souza");

        conta3.setBanco("341 - BANCO ITAU UNIBANCO");
        conta3.setNumero("09873-6");
        conta3.setAgencia("0988");
        conta3.setTitular("Antonio Duraes");

        conta4.setBanco("033 - BANCO SANTANDER");
        conta4.setNumero("12345-6");
        conta4.setAgencia("5874");
        conta4.setTitular("Lenadra Marques");

        conta5.setBanco("104 - CAIXA ECONOMICA FEDERAL");
        conta5.setNumero("85478-3");
        conta5.setAgencia("5588");
        conta5.setTitular("Alexandre Duarte");

        em.getTransaction().begin();
        
        em.persist(conta1);
        em.persist(conta2);
        em.persist(conta3);
        em.persist(conta4);
        em.persist(conta5);

        em.getTransaction().commit();

        em.close();
    }
    
}