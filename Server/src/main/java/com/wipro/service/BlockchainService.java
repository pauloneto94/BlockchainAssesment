package com.rookie.training.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import com.rookie.training.entity.Block;
import com.rookie.training.entity.BlockData;
import com.rookie.training.entity.Blockchain;
import com.rookie.training.entity.Transaction;

public class BlockchainService {
	
	Blockchain blockchain = new Blockchain(new Block(1, "12312", new ArrayList<Transaction>(), 123, "0ae1234", "00"), 2);

	public List<Transaction> findTransactions(String name) {
		
		List<Transaction> transactionByName = new ArrayList<Transaction>();
		
		for( Block bl : blockchain.chain) {
			
			for(Transaction t : bl.transactions) {
				
				if( t.getSender() == name) transactionByName.add(t);
				
			}
			
		}
		
		return transactionByName;
		
	}

	public double findAmount(String name) {
	
		double madeTransaction = 0.0;
		double recivedTransaction = 0.0;
		
		for( Block bl : blockchain.chain) {
			
			for(Transaction t : bl.transactions) {
				
				if( t.getSender() == name) madeTransaction += t.getAmount();
				
				if( t.getRecipient() == name) recivedTransaction += t.getAmount();
				
				
			}
			
		}
		
		return madeTransaction - recivedTransaction;
	}

	public void addTransaction(Integer amount, String sender, String recipient) {
		
		blockchain.addTransactionToPending(new Transaction(amount, sender, recipient));
		
	}
	
	public boolean mine() throws NoSuchAlgorithmException {
		
		Block latestBlock = this.blockchain.getLatestBlock();
		String previousHash = latestBlock.hash;
		BlockData currentBlockData = new BlockData(new Block(Integer.valueOf(latestBlock.index + 1), null, this.blockchain.pendingTransactions, 0, null, null));
		String nonce = this.blockchain.proofOfWork(previousHash, currentBlockData);
		String hash = this.blockchain.hashBlock(previousHash, currentBlockData, Integer.valueOf(nonce));
		Block block = this.blockchain.newBlock(Integer.valueOf(nonce), previousHash, hash);
		
		return this.blockchain.validadeBlock(block, latestBlock);
		
		
	}

}
