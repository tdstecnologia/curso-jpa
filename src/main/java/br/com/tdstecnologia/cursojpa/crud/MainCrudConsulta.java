package br.com.tdstecnologia.cursojpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainCrudConsulta {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {

            Carro carro = em.find(Carro.class, 3);

            if(carro != null){
                System.out.println(carro);
            }else{
                System.out.println("Nenhum registro encontrado...");
            }

        } finally {
            em.close();
            emf.close();
        }
    }

}
