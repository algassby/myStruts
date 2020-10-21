package com.barry.myStruts.service;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String fonction;

	private String nom;

	private String poste;

	private int tel;
	private String sexe;
	private int age;

	public Person() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
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

	@Override
	public String toString() {
		StringBuffer person = new StringBuffer();
		person.append(id).append(", ").append(nom).append(" ,").append(age).append(" ,").append(sexe).append(", ").append(poste).append(" ,").append(fonction).append(" ,").append(tel);
		return  person.toString();
				
	}
	

}