package br.com.rodolfo.financas.teste;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.Movimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Movimentacao movimentacao = em.find(Movimentacao.class, 3);

        Conta conta = movimentacao.getConta();

        System.out.println(conta.getTitular());

        //Verificar quantas movimentacoes a conta possui, já que possui relação N movimentações para 1 conta.
        //Se não colocarmos o MappedBy=conta na anotação OneToMany na classe Conta a JPA irá criar outra tablea 'Conta_Movimentacao' pois ela não saberá que existe esse relacionamento.
        System.out.println(conta.getMovimentacoes().size());


        em.close();
    }


}