package br.com.rodolfo.financas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;

public class MovimentacaDAO {

    private EntityManager em;

    public MovimentacaDAO(EntityManager em) {

        this.em = em;
    }

    public List<Double> getMedia(Conta conta, TipoMovimentacao tipo) {
        
        TypedQuery<Double> query = this.em.createNamedQuery("MediaMovimentacoes", Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipo);

        return query.getResultList();
    }


}