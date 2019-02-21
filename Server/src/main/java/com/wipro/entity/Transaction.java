package com.rookie.training.entity;

import java.util.UUID;

public class Transaction {
	
	public String id;
	public Integer amount;
	public String sender;
	public String recipient;
	
	public Transaction(Integer amount, String sender, String recipient) {
		
		this.id = UUID.randomUUID().toString();
		this.amount = amount;
		this.sender = sender;
		this.recipient = recipient;
		
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	

}
