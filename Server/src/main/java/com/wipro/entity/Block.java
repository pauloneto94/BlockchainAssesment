package com.rookie.training.entity;

import java.util.List;

public class Block {
	
	public int index;
	public String timestamp;
	public List<Transaction> transactions;
	public int nonce;
	public String hash;
	public String previousHash;
	
	public Block(int index, String timestamp, List<Transaction> transactions, int nonce, String hash, String previousHash) {
	
		this.index = index;
		this.timestamp = timestamp;
		this.transactions = transactions;
		this.nonce = nonce;
		this.hash = hash;
		this.previousHash = previousHash;
		
	}


}
