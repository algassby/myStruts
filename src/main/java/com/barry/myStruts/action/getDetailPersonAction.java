package com.barry.myStruts.action;

import com.barry.myStruts.controleur.Manager;

public class getDetailPersonAction {

	private String  nom;
	private String fonction;

	private String poste;

	private int tel;
	private int id;
	private String sexe;
	private int age;
	
	
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


	private String display() {
		
		Manager.getInstance().getOnePersonById(id);
		return "SUCCESS";
	}
	

}
