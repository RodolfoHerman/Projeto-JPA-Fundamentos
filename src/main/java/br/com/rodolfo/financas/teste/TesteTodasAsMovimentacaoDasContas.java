package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteTodasAsMovimentacaoDasContas {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();

        //Criando um JPQL Lazy loading (busca tardia), ou seja, ela fará um SELECT de todas as contas. No loop FOR ao buscar as Movimentações das contas, o JPA fará um SELECT para cada movimentação de cada conta caindo no caso N + 1
        String jpql1 = "SELECT c FROM Conta c";

        //Podemos evitar o LAZY LOADING realizando uma query mais bem elaborada e buscando todas as movimentações de uma vez. O parâmetro JOIN FETCH quer dizer que queremos juntar, nesta query, a conta e a movimentação trazendo as colunas da tabela Conta e as colunas da tabela Movimentacao. Esse comportamento é conhecido como EAGER LOADING
        String jpql2 = "SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.movimentacoes";

        //Query query = em.createQuery(jpql1);
        Query query = em.createQuery(jpql2);

        List<Conta> contas = query.getResultList();

        for (Conta conta : contas) {
            
            System.out.println("Titular : " + conta.getTitular());
            System.out.println("Movimentacoes : ");
            //Aqui podemos ver o LAZY LOADING, carregamento de forma tardia das movimentacoes. O problema são os números de consultas realizadas ao banco de dados. Para cada conta é realizada uma query para buscar as suas movimentações. (Obs: utilizando a jpql1)
            System.out.println(conta.getMovimentacoes());
        }

        em.close();
    }


}