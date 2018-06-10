package br.com.rodolfo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rodolfo.financas.modelo.DataTransferObject;
import br.com.rodolfo.financas.util.JPAUtil;

public class TesteDataTransferObject {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();

        List<DataTransferObject> contas = em.createQuery("SELECT NEW br.com.rodolfo.financas.modelo.DataTransferObject(c.numero, c.agencia) FROM Conta c", DataTransferObject.class).getResultList();

        for (DataTransferObject conta : contas) {
            
            System.out.println("AGENCIA : " + conta.getAgencia());
        }

        em.close();
    }


}