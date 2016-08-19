package com.exteam.kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Account> listAccount1 = new ArrayList<Account>();
		List<Account> listAccount2 = new ArrayList<Account>();
		// create accounts
		Account account1 = new Account();
		account1.setIban("DE68210501700012345678");
		account1.setBalance(new BigDecimal(1000));
		account1.setIdAccount(1L);
		listAccount1.add(account1);
		Account account2 = new Account();
		account2.setIban("R251105017000123455684");
		account2.setBalance(new BigDecimal(2000));
		account2.setIdAccount(2L);
		listAccount1.add(account2);
		Account account3 = new Account();
		account3.setIban("FE68210501700012342564");
		account3.setBalance(new BigDecimal(1200));
		account3.setIdAccount(3L);
		listAccount2.add(account3);
		Account account4 = new Account();
		account4.setIban("YT51105017000123452541");
		account4.setBalance(new BigDecimal(700));
		account4.setIdAccount(4L);
		listAccount2.add(account4);
		// create clients
		Client client1 = new Client("Dupont", "Julien", listAccount1);
		Client client2 = new Client("Martin", "Aubert", listAccount2);
		// Create traitement 1
		Traitement traitement = new Traitement();
		// Client 1 make a deposit in account 1
		BigDecimal amount = new BigDecimal("500");
		account1 = traitement.depositAmount(account1, amount);
		// get transactions for account 1
		traitement.getTransactionsByAccount(client1, 1L);
		// Client 1 make a withdrawal in account 1
		account1 = traitement.withdrawalAmount(account1, amount);
		// get transactions for account 1
		traitement.getTransactionsByAccount(client1, 1L);
		// Create traitement 1
		Traitement traitement2 = new Traitement();
		// Client 2 make a deposit in account 3
		BigDecimal amount2 = new BigDecimal("100");
		account3 = traitement2.depositAmount(account3, amount2);
		// get transactions for account 3
		traitement2.getTransactionsByAccount(client2, 3L);
		// Client2 make a withdrawal in account 3
		account3 = traitement2.withdrawalAmount(account3, amount2);
		// get transactions for account 3
		traitement.getTransactionsByAccount(client2, 3L);
	}
}
