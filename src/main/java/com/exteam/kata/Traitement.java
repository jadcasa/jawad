package com.exteam.kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Traitement {

	/** The log. */
	private static Logger log = Logger.getLogger(Traitement.class);

	private List<Transaction> listTransaction = new ArrayList<Transaction>();

	public Account depositAmount(Account account, BigDecimal amount) {
		account.setBalance(account.getBalance().add(amount));
		Transaction transaction = new Transaction(amount, Operation.DEPOSIT, new Date(), account.getBalance());
		listTransaction.add(transaction);
		account.setListTransaction(listTransaction);
		log.info("new balance after deposit " + account.getBalance());
		return account;
	}

	public Account withdrawalAmount(Account account, BigDecimal amount) {
		account.setBalance(account.getBalance().subtract(amount));
		Transaction transaction = new Transaction(amount, Operation.WITHDRAWAL, new Date(), account.getBalance());
		listTransaction.add(transaction);
		account.setListTransaction(listTransaction);
		log.info("new balance after withdrawal" + account.getBalance());
		
		return account;
	}

	public List<Transaction> getTransactionsByAccount(Client client, Long IdAccount) {
		List<Transaction> listTransactions = new ArrayList<Transaction>();
		List<Account> listAccount = client.getListAccount();
		for (Account account : listAccount) {
			if (account.getIdAccount() == IdAccount) {
				listTransactions = account.getListTransaction();
				log.info("nombre des  transactions " +  listTransactions.size());
				for(Transaction transaction :listTransactions ){
					log.info("Liste des transactions " +  transaction.toString());
					
				}
				
			}
		}
		return listTransactions;
	}
}
