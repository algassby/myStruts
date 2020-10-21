package com.barry.myStruts.action;

import java.util.ArrayList;
import java.util.List;

import com.barry.myStruts.controleur.Manager;
import com.barry.myStruts.service.Person;

public class UpdateAction {

	
	private List<Person> listPerson;
	
	private String  nom;
	private String fonction;

	private String poste;

	private int tel;
	private int id;
	private String sexe;
	private int age;
	
	

	public UpdateAction() {
		listPerson = Manager.getInstance().getPersonList();
	}

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

	/***
	 * action modifier
	 * @return UPDATE
	 */
	public String update() {
		
		Person obj = new Person();
		obj.setId(this.getId());
		obj.setFonction(this.getFonction());
		obj.setNom(this.getNom());
		obj.setPoste(this.getPoste());
		obj.setTel(this.getTel());
		obj.setSexe(this.getSexe());
		obj.setAge(this.getAge());
		
		Manager.getInstance().update(this.getId(), obj );
		System.out.println(obj);
		
		
		return "UPDATE";
		
	}

	
	
}
