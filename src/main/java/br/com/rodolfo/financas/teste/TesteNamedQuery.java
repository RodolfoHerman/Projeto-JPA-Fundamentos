package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteNamedQuery {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(3);

        //Chamando a 'Named Query' definida na classe Movimentacao
        TypedQuery<Double> query = em.createNamedQuery("MediaMovimentacoes", Double.class);
        
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> medias = query.getResultList();

        for (Double media : medias) {
            
            System.out.println("A MEDIA E : " + media);
        }

        em.close();
    }


}