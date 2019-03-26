package br.com.tdstecnologia.cursojpa.enums;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainEnum {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CONEXAO_MYSQL");
        EntityManager em = emf.createEntityManager();

        try {
            TbEnum tb = new TbEnum();
            tb.setDiaSemanaNome(EnumSemama.SEGUNDA);
            tb.setDiaSemanaIndice(EnumSemama.TERCA);
            
            tb.setDiaSemanaNomeCustom(EnumSemama.DOMINGO);
            tb.setDiaSemanaIndiceCustom(EnumSemama.DOMINGO);
            
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(tb);
            tx.commit();

            

        } finally {
            em.close();
            emf.close();
        }

    }

}
