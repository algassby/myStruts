package com.barry.myStruts.action;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.barry.myStruts.controleur.Manager;
import com.barry.myStruts.service.Person;

public class createAction {


	private List<Person> listPerson;
	
	private String  nom;
	private String fonction;

	private String poste;

	private int tel;
	private int id;
	private String sexe;
	private int age;
	
	
	
	public List<Person> getListPerson() {
		return listPerson;
	}
	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String create() {
		
		
		Person person = null;
		person = new Person();
		person.setId(this.id);
		person.setNom(this.nom);	
		person.setPoste(this.poste);
		person.setFonction(this.fonction);
		person.setTel(this.tel);
		person.setAge(this.age);
		person.setSexe(this.sexe);
		Manager.getInstance().create(person);
		listPerson = Manager.getInstance().getPersonList();
		
		listPerson.add(person);
		System.out.println(listPerson.toString());
		return "CREATE";
		
		
	}
}
