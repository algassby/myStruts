package com.barry.myStruts.stockage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.barry.myStruts.service.Person;

public class JpaAcces implements Dao<Person> {
private EntityManager em;

	public JpaAcces() {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("myStruts");
		em = emf.createEntityManager();
}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> lireTous() {
		return em.createNamedQuery("findAll").getResultList();
	}

	@Override
	public void ecrireTous(List<Person> elt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(int cle, Person obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier(Person obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer(Person obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer(int cle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouter(Person obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNombreEnregistrement() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Person getPersonne(int cle) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String [] args) {
		
		JpaAcces acces = null;
		acces = new JpaAcces();
		acces.lireTous().stream().forEach(System.out::print);
		
	}

}
