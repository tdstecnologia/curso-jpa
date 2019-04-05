package br.com.tdstecnologia.cursojpa.relacionamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Maiin {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {

            CursoPessoaPK pk = new CursoPessoaPK(1, 1);
            CursoPessoa cp = new CursoPessoa(pk);
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            em.persist(cp);
            tx.commit();

        } finally {
            em.close();
            emf.close();
        }
    }
}
