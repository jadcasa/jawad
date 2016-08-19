package com.exteam.kata.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exteam.kata.Account;
import com.exteam.kata.AppConf;
import com.exteam.kata.Client;
import com.exteam.kata.Operation;
import com.exteam.kata.Traitement;
import com.exteam.kata.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfTest.class,AppConf.class})
public class AccountBankTest {

	private Client client;

	private Account account;


	 @Autowired
	private Traitement  traitement;
	/** The log. */
	private static Logger log = Logger.getLogger(AccountBankTest.class);

	@Before
	public void setUp() {
		log.debug("Start AccountBankTest.setUp");
		List<Account> listAccount = new ArrayList<Account>();
		List<Transaction> listTransactions = new ArrayList<Transaction>();
		account = new Account();
		account.setIban("DE68210501700012345678");
		account.setBalance(new BigDecimal(1000));
		account.setIdAccount(1L);
		listAccount.add(account);
		Account account2 = new Account();
		account2.setIban("R251105017000123455684");
		account2.setBalance(new BigDecimal(2000));
		account2.setIdAccount(2L);
		listAccount.add(account2);
		Transaction transaction1 = new Transaction(new BigDecimal(500), Operation.DEPOSIT, new Date(), account.getBalance());
		Transaction transaction2 = new Transaction(new BigDecimal(300), Operation.WITHDRAWAL, new Date(), account.getBalance());
		listTransactions.add(transaction1);
		listTransactions.add(transaction2);
		account.setListTransaction(listTransactions);
		client = new Client("Dupont", "Julien", listAccount);
		log.debug("End AccountBankTest.setUp");
	}

	
	@Test
	public void testDepositAmount() {
		log.debug("Start AccountBankTest.testDepositAmount");
		BigDecimal amount = new BigDecimal("500");
		BigDecimal newBalance = new BigDecimal("1500");
		Account result = traitement.depositAmount(account, amount);
		Assert.assertEquals(newBalance, result.getBalance());
		log.debug("End AccountBankTest.testDepositAmount");
	}
	

	@Test
	public void testWithdrawalAmount() {
		log.debug("Start AccountBankTest.testWithdrawalAmount");
		BigDecimal amount = new BigDecimal("500");
		BigDecimal newBalance = new BigDecimal("500");
		Traitement traitement = new Traitement();
		Account result = traitement.withdrawalAmount(account, amount);
		Assert.assertEquals(newBalance, result.getBalance());
		log.debug("End AccountBankTest.testWithdrawalAmount");
	}
	
	@Test
	public void testListTransaction() {
		log.debug("Start AccountBankTest.testWithdrawalAmount");
		Traitement traitement = new Traitement();
		List<Transaction> listTransaction = traitement.getTransactionsByAccount(client , account.getIdAccount());
		Assert.assertEquals(2, listTransaction.size());
		log.debug("End AccountBankTest.testWithdrawalAmount");
	}
}
