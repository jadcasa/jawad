package com.exteam.kata;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.google.common.base.Objects;

public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idTransaction;

	private Operation operation;

	private Date dateTransaction;

	private BigDecimal amount;

	private BigDecimal balance;

	public Transaction(BigDecimal balance, Operation operation, Date dateTransaction, BigDecimal amount) {
		super();
		this.balance = balance;
		this.operation = operation;
		this.dateTransaction = dateTransaction;
		this.amount = amount;
	}

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("operation", operation).add("dateTransaction", dateTransaction).add("amount", amount).toString();
	}
}
