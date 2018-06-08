package br.com.rodolfo.financas.teste;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Cliente;
import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.util.JPAUtil;

public class TestaContaCliente {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Rodolfo");
        cliente1.setEndereco("Aguas de Março");
        cliente1.setProfissao("Programador");

        // Com a anotação 'JoinColumn' na classe Cliente foi adicionado a restrição da cahve estrangeira
        // Cliente cliente2 = new Cliente();
        // cliente2.setNome("Rodolfo");
        // cliente2.setEndereco("Aguas de Março");
        // cliente2.setProfissao("Programador");

        Conta conta = new Conta();
        conta.setId(1);

        cliente1.setConta(conta);
        
        //cliente2.setConta(conta);

        em.getTransaction().begin();

        em.persist(cliente1);
        
        //em.persist(cliente2);

        em.getTransaction().commit();

        em.close();
    }

}