package br.com.tdstecnologia.cursojpa.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoTeste {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();

    }
}
