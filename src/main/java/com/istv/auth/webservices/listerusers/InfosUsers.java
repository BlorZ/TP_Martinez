package com.istv.auth.webservices.listerusers;

import java.util.List;

import com.istv.auth.model.Compte;

public class InfosUsers {

	private String username;
	private List<Compte> comptes;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
