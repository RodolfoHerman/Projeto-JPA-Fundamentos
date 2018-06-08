package br.com.rodolfo.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Categoria;
import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.Movimentacao;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteMovimentacaoComCategoria {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negocios");
        
        Movimentacao movimentacao1 = new Movimentacao();
        Movimentacao movimentacao2 = new Movimentacao();

        Conta conta = new Conta();
        conta.setId(3);

        movimentacao1.setDescricao("Viagem a SP");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setData(Calendar.getInstance());
        movimentacao1.setValor(new BigDecimal("350.00"));
        movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao1.setConta(conta);

        movimentacao2.setDescricao("Viagem a RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setData(Calendar.getInstance());
        movimentacao2.setValor(new BigDecimal("250.00"));
        movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
        
        movimentacao2.setConta(conta);

        em.getTransaction().begin();

        em.persist(categoria1);
        em.persist(categoria2);

        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();

        em.close();
    }


}