package br.com.tdstecnologia.cursojpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainCrudExcluir {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {

            Carro ana = em.find(Carro.class, 2);

            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.remove(ana);
            tx.commit();

        } finally {
            em.close();
            emf.close();
        }
    }

}
