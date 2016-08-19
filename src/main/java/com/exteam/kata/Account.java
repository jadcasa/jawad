package com.exteam.kata;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAccount;
	private String iban;
	
	private BigDecimal balance;
	
	private List<Transaction> listTransaction = new ArrayList<Transaction>();

	
	public Long getIdAccount() {
		return idAccount;
	}

	
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	
	public String getIban() {
		return iban;
	}

	
	public void setIban(String iban) {
		this.iban = iban;
	}

	
	
	
	public BigDecimal getBalance() {
		return balance;
	}

	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	
	public List<Transaction> getListTransaction() {
		return listTransaction;
	}

	
	public void setListTransaction(List<Transaction> listTransaction) {
		this.listTransaction = listTransaction;
	}


	@Override
	public String toString() {
		return "Account [ balance=" + balance + ", listTransaction=" + listTransaction + "]";
	}
	
	
	
	
	
	
}
