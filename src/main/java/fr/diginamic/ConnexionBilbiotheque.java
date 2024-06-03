package fr.diginamic;

import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionBilbiotheque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("configBiblio");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction= em.getTransaction();
		transaction.begin();
		
		Livre l= em.find(Livre.class, 1);
		if (l!= null){
		System.out.println(l.getTitre()+": "+l.getAuteur());
		}
		
		Emprunt e= em.find(Emprunt.class, 1);
		if (e!= null){
			Set<Livre>livres=e.getLivres();
			
			for(Livre livre: livres) {
		System.out.println(livre.getTitre()+": "+livre.getAuteur());
			}
		}
		
		Client c= em.find(Client.class, 1);
		if (c!= null){
			Set<Emprunt>emprunts=c.getEmprunts();
			
			for(Emprunt emprunt: emprunts) {
		System.out.println(emprunts.size());
			}
		}
		
		
		
		
		transaction.commit();

	}

}
