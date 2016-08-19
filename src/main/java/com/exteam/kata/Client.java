package com.exteam.kata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long IdClient;
	
	private String nom ;
	
	private String prenom;
	
	private List<Account> listAccount = new ArrayList<Account>();

	
	
	
	
	public Long getIdClient() {
		return IdClient;
	}


	
	public void setIdClient(Long idClient) {
		IdClient = idClient;
	}


	public String getNom() {
		return nom;
	}

	
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public String getPrenom() {
		return prenom;
	}

	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	
	public List<Account> getListAccount() {
		return listAccount;
	}



	
	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}



	public Client(String nom, String prenom, List<Account> listAccount) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.listAccount = listAccount;
	}


	
	
	
	
}
