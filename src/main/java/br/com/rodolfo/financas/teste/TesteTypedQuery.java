package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteTypedQuery {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(3);
        
        String jpql = "SELECT AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo GROUP BY m.data";

        //Sabemos o tipo de retorno da query, então podemos informar ao compilador o que será retornado e assegurar o correto funcionamento do código. Utilizamos o TypedQuery informando pelo 'generics' o tipo de retorno e no createQuery informamos a classe de retorno
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> medias = query.getResultList();

        for (Double media : medias) {
            
            System.out.println("A MEDIA E : " + media);
        }


        em.close();
    }


}