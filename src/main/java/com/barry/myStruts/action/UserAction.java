/**
 * 
 */
package com.barry.myStruts.action;


import java.util.ArrayList;
import java.util.List;

import com.barry.myStruts.controleur.Manager;
import com.barry.myStruts.service.Person;


/**
 * @author algas
 *
 */
public class UserAction {

	private List<String> sexeRadio;
	private List<Integer> ageselect;
	
	private String username;
	private String msg;
	private List<Person> list;
	private String  nom;
	private String fonction;

	private String poste;

	private int tel;
	private int id;
	private String sexe;
	private int age;
	
	/**
	 * 
	 */
	public UserAction() {
		// TODO Auto-generated constructor stub
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


	public void setList(List<Person> list) {
		this.list = list;
	}
	


	public List<Person> getList() {
		return list;
	}


	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void init() {
		msg = "failed username!";
		list = Manager.getInstance().getPersonList();
		list.stream().forEach(System.out::println);
	}

	public String error() {
		if(!this.getUsername().equals("barry")) {
			msg = "failed username!";
			
		}
		return "ERROR";
		
	}
	
	public String welcome() {
	
		sexeRadio = new ArrayList<String>();
		sexeRadio.add("Homme");
		sexeRadio.add("Femme");
		
		ageselect = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			ageselect.add(i);
		}
		System.out.println(this.getAgeselect());
		list = Manager.getInstance().getPersonList();
		System.out.println(list);
		return "SUCCESS";
	}
	

}
