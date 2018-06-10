package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.Movimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteLazyLoadingException {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = em.find(Conta.class, 3);

        List<Movimentacao> movimentacaos = conta.getMovimentacoes();

        em.close();
        
        //Irá dar exception pois a EntityManager foi fechada e o JPA irá realizar a LAZY LOADING, ou seja, somente quando for necessário utilizar a movimentação, realizar o print, que ele realizará a query caso na anotação @OneToMany na classe Conta não possuir o parâmetro fetch=FetchType.EAGER
        for (Movimentacao movimentacao : movimentacaos) {
            
            System.out.println("DESCRICAO : " + movimentacao.getDescricao());
        }

    }


}