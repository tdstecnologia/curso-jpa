package br.com.tdstecnologia.cursojpa.query;

import br.com.tdstecnologia.cursojpa.relacionamento.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Queries {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {

            Queries query = new Queries();
            query.pesquisarPorCpf(em,"021");
            
        } finally {
            em.close();
            emf.close();
        }

    }

    public void pesquisarPorCpf(final EntityManager em, final String cpf) {
        TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p WHERE p.cpf = :cpf", Pessoa.class);
        query.setParameter("cpf", cpf);
        Pessoa pessoa = query.getSingleResult();
        System.out.println("Pessoa: "+pessoa.getNome());
    }

}
