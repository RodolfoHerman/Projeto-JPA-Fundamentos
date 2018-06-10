package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rodolfo.financas.modelo.Categoria;
import br.com.rodolfo.financas.modelo.Movimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(2);


        em.getTransaction().begin();

        //Construindo o JOIN com 'Categoria' que é uma relação N para N o JPA abstraí os JOIN's entre as tabelas para o programador
        String jpql = "SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria";


        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacaos = query.getResultList();

        for (Movimentacao movimentacao : movimentacaos) {

            System.out.println("MOVIMENTACAO : " + movimentacao.getDescricao());
            System.out.println("CATEGORIA : " + movimentacao.getCategoria().get(0).getNome());
        }

        System.out.println(movimentacaos.size());

        em.close();
    }


}