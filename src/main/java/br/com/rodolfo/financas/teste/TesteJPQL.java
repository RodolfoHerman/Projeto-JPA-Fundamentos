package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.modelo.Movimentacao;
import br.com.rodolfo.financas.modelo.TipoMovimentacao;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteJPQL {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

        em.getTransaction().begin();

        //EM vez de usarmos querys padrões SQL para relizar consultas, utilizamos a JPQL. Vamos distanciar ao máximo de trabalhar com SQL que é relacional e trabalhar com JPQL no mundo orientado a objetos.

        //String sql = "SELECT * FROM Movimentacao WHERE id_conta = :idConta AND tipo = :tipoMov ORDER BY valor";

        //Em vez de usar na consulta as colunas da tabela relacional utilizamos os atributos do objeto. No caso o objeto m acessamos o seu atributo 'conta' (que é um objeto) e passamos como parâmetro ':pConta' um objeto do tipo Conta. A anotação com ':p' antes de Conta é uma conveção indicando que é um Parameter.Não precisamos referenciar a uma chave estrangeira já que é algo que faz parte do modelo relacional e sim ao objeto
        String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo ORDER BY m.valor ASC";

        //Forma ligada mais ao SQL
        //String sql_jpql = "SELECT m FROM Movimentacao m WHERE m.cont.id = 3 AND m.tipo = 'ENTRADA'";

        //Query query = em.createQuery(sql);
        Query query = em.createQuery(jpql);
        
        //query.setParameter("idConta", conta.getId());
        //query.setParameter("tipoMov", TipoMovimentacao.ENTRADA);
        
        //Passar os valores para a Named Parameter -- parâmetros nomeados. A vantagem de se usar NAMED PARAMETER é que são identificados por nomes em vez de posições na query
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("DESCRICAO : " + movimentacao.getDescricao());
            System.out.println("ID CONTA : " + movimentacao.getConta().getId());
        }

        em.close();

    }
    

}