package br.com.tdstecnologia.cursojpa.query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Bulk {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();

            Bulk bulk = new Bulk();
            tx.begin();
            bulk.atualizacaoEmLote(em);
            tx.commit();

        } finally {
            em.close();
            emf.close();
        }

    }

    public void atualizacaoEmLote(final EntityManager em) {
        Query query = em.createQuery("UPDATE Curso c SET c.valor = c.valor * 1.5");
        query.executeUpdate();
    }
}
