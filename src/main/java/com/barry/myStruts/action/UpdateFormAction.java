package com.barry.myStruts.action;

import java.util.ArrayList;
import java.util.List;

import com.barry.myStruts.controleur.Manager;
import com.barry.myStruts.service.Person;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateFormAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private String fonction;

	private String poste;

	private int tel;
	private String sexe;
	private int age;
	
	private List<String> sexeRadio;
	private List<Integer> ageselect;
	

	
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


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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
	
	


	public List<String> getSexeRadio() {
		return sexeRadio;
	}


	public void setSexeRadio(List<String> sexeRadio) {
		this.sexeRadio = sexeRadio;
	}


	public List<Integer> getAgeselect() {
		return ageselect;
	}


	public void setAgeselect(List<Integer> ageselect) {
		this.ageselect = ageselect;
	}


	public String update() {

		sexeRadio = new ArrayList<String>();
		sexeRadio.add("Homme");
		sexeRadio.add("Femme");
		
		ageselect = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			ageselect.add(i);
		}
		System.out.println(Manager.getInstance().getOnePersonById(id));
		this.nom = Manager.getInstance().getOnePersonById(id).getNom();
		this.poste = Manager.getInstance().getOnePersonById(id).getPoste();
		this.fonction = Manager.getInstance().getOnePersonById(id).getFonction();
		this.tel = Manager.getInstance().getOnePersonById(id).getTel();
		this.age =  Manager.getInstance().getOnePersonById(id).getAge();
		this.sexe =  Manager.getInstance().getOnePersonById(id).getSexe();
		System.out.println(id);
		
		return "SUCCESS";
		
	}
}
