package com.barry.myStruts.controleur;

import java.util.List;

import javax.sound.midi.Soundbank;

import com.barry.myStruts.service.Person;
import com.barry.myStruts.stockage.Dao;
import com.barry.myStruts.stockage.DaoFactoryUSER;

/**
 * 
 * @author algas
 * Classe Manager
 *
 */
public class Manager {
	private static Manager instance = new  Manager();
	private Dao<Person> acces;

	
	
	
	private Manager() {
		
		init();
		
	}
	
	public void delete(int cle) {
		acces.effacer(cle);
	}
/**
 * 
 * @return l'instance
 */
	public static Manager getInstance() {
		return instance;
	}
	public List<Person>getPersonList(){
		
		return acces.lireTous(); 
		
	}
	/**
	 * update
	 */
	
	public void update(int cle, Person obj) {
		
		acces.modifier(cle, obj);
		
	}
	public void create(Person obj) {
		
		acces.ajouter(obj);
		
	}
	
	public Person getOnePersonById(int cle) {
		
		return acces.getPersonne(cle);
		
	}
	public void init() {
		acces = DaoFactoryUSER.getInstance().getClassDao();
		
	}

	public static void main(String []args) {
		Manager.getInstance().getPersonList().forEach(System.out::println);
		System.out.println(Manager.getInstance().getOnePersonById(2));
		
	}
	

}
