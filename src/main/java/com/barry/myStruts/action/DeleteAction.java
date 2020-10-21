package com.barry.myStruts.action;

import com.barry.myStruts.controleur.Manager;

public class DeleteAction {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String delete() {
		System.out.println(id);
		Manager.getInstance().delete(id);
		return "DELETE";
		
	}
}
