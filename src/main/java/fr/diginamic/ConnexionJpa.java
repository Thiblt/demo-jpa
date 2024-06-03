package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("configBdd");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction= em.getTransaction();
		transaction.begin();
		Region r= new Region();
		r.setNom("Nouvelle-Aquitaine");
		em.persist(r);
		
		Region r2= em.find(Region.class, 3);
		if (r2!= null){
		System.out.println(r2.getNom());
		}
		
		
		transaction.commit();
		

	}

}
