package br.com.rodolfo.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(3);

        String jpql = "SELECT AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo";

        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        //O dado tem que ser tratado de acordo com o tipo do atributo da classe que é BigDecimal
        //BigDecimal soma = (BigDecimal) query.getSingleResult();

        //A média trabalha como DOUBLE e não BigDecimal
        Double media = (Double) query.getSingleResult();

        //System.out.println("A SOMA E : " + soma);
        System.out.println("A MEDIA E : " + media);

        em.close();
    }
}