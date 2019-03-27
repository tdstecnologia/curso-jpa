package br.com.tdstecnologia.cursojpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainCrudAtualizar {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {

            Carro carro = em.find(Carro.class, 3);

            if (carro != null) {
                EntityTransaction tx = em.getTransaction();

                tx.begin();
                carro.setModelo("Gol G8");
                em.merge(carro);
                tx.commit();

            } else {
                System.out.println("Nenhum registro encontrado...");
            }

        } finally {
            em.close();
            emf.close();
        }
    }

}
