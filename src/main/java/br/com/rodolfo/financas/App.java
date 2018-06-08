package br.com.rodolfo.financas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodolfo.financas.modelo.Conta;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Conta conta = new Conta();

        conta.setTitular("Rodolfo");
        conta.setAgencia("123");
        conta.setBanco("Caixa Economica");
        conta.setNumero("456");

        //Para criar o 'EntityManagerFactory' usamos a classe 'Persistence' que representa o arquivo 'persistence.xml', passamos como parâmetro a unidade de persistência 'financas' que utiliza as configurações para acessar o banco de dados. Podemos criar outras  'EntityManagerFactory' que acessam outros BD's (como SqlServer) criando outras unidades de persistências no arquivo 'persistence.xml'
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");

        //Ciração da instancia do JPA para persistirmos os dados no banco
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
