package br.com.tdstecnologia.cursojpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainCrudSalvar {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {

            Carro ana = new Carro("Gol");
            
            EntityTransaction tx = em.getTransaction();
            
            tx.begin();
            em.persist(ana);
            tx.commit();

        } finally {
            em.close();
            emf.close();
        }
    }

}
