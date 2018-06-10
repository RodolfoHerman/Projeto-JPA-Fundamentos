package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;
import br.com.rodolfo.financas.repository.MovimentacaDAO;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteMovimentacaoDAO {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(3);

        MovimentacaDAO dao = new MovimentacaDAO(em);

        List<Double> medias = dao.getMedia(conta, TipoMovimentacao.SAIDA);

        for (Double media : medias) {
            
            System.out.println("A MEDIA E : " + media);
        }

        em.close();
    }
    

}