package br.com.rodolfo.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.Movimentacao;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteJPARelacionamento {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setAgencia("001");
        conta.setBanco("001 - BANCO INTER S.A");
        conta.setNumero("25478");
        conta.setTitular("Rodolfo Hemrna Lara e Silva");

        Movimentacao movimentacao = new Movimentacao();

        //Calendar.getInstance() pega a data e hora atual
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Padaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("98.00"));
        movimentacao.setConta(conta);

        em.getTransaction().begin();

        //Como a conta ainda não existe no banco de dados, é necessário tirar-la do estado TRANSIENT e passa-la para o estado MANAGED, no caso o insert com o persist. A conta poderia estar no estado DETACHED ou ainda podemos criar um objeto conta e setar o ID com um exitente no banco de dados.
        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();

        em.close();
    }


}