package br.com.rodolfo.financas;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.Conta;
import br.com.rodolfo.financas.util.JPAUtil;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Conta conta = new Conta();

        conta.setTitular("Rodolfo Teste");
        conta.setAgencia("123");
        conta.setBanco("Caixa Economica");
        conta.setNumero("456");

        //Para criar o 'EntityManagerFactory' usamos a classe 'Persistence' que representa o arquivo 'persistence.xml', passamos como parâmetro a unidade de persistência 'financas' que utiliza as configurações para acessar o banco de dados. Podemos criar outras  'EntityManagerFactory' que acessam outros BD's (como SqlServer) criando outras unidades de persistências no arquivo 'persistence.xml'
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");

        //Ciração da instancia do JPA para persistirmos os dados no banco
        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        
        //O objeto 'conta' antes do 'persist' está no estado de TRANSIENT, ou seja, é um objeto não gerenciado pelo JPA e não há resgistros no banco de dados (O objeto nunca foi gerenciado pelo JPA). Após o 'persist' o objeto passa para o estado 'MANAGED' há o registro no banco de dados e o objeto passa a ser gerenciado/sincronizado pelo JPA. O estado MANAGED dura enquanto o 'EntityManager' estiver aberto.
        em.persist(conta);
        
        
        em.getTransaction().commit();


        em.close();

        //Não é mais neecssário fechar a fabrica de entities pois exites apenas uma instância em memória dela (uso do static)
        //emf.close()
    }
}
