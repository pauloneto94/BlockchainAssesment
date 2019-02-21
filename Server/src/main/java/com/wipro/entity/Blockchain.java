package com.rookie.training.entity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Blockchain {
	
	public List<Block> chain = new ArrayList<Block>();
	public List<Transaction> pendingTransactions;
	public String nodeUrl;
	public List<String> networkNodes;
	public Integer dificulty;
	
	public Blockchain(Block GENESIS_BLOCK, Integer dificulty) {
		
		this.chain.add(GENESIS_BLOCK);
		this.nodeUrl = UUID.randomUUID().toString();
		this.dificulty = dificulty;
			
	}
	
	public Block newBlock(int nonce, String previousHash, String hash) {
		
		Block newBlock = new Block(this.chain.size() + 1, "PauloNeto", this.pendingTransactions, nonce, hash, previousHash);
		
		this.chain.add(newBlock);
		
		return newBlock;
		
	}
	
	public Block getLatestBlock() {
		
		return this.chain.get(this.chain.size()-1);
		
	}
	
	public String hashBlock(String previousHash, BlockData blockData, int nonce) throws NoSuchAlgorithmException {
		
		String data = previousHash + blockData.toString() + nonce;
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(
		  data.getBytes(StandardCharsets.UTF_8));
		
		return hash.toString();
		
	}
	
	public String proofOfWork(String previousHash, BlockData currentBlockData) throws NoSuchAlgorithmException {
		
		Integer nonce = 0;
		
		String hash = this.hashBlock(previousHash, currentBlockData, nonce);
		
		while(hash.substring(0, this.dificulty) != this.chain.get(0).hash.substring(0, this.dificulty)) {
			
			nonce ++;
			
			hash = this.hashBlock(previousHash, currentBlockData, nonce);
			
		}
		
		return nonce.toString();
	}
	
	public boolean validadeBlock(Block block, Block previousBlock) throws NoSuchAlgorithmException {
		
		if(block.previousHash != previousBlock.hash) return false;
		
		String validadeBlockHash = this.hashBlock(block.previousHash, new BlockData(block), block.nonce);
		
		if(validadeBlockHash != block.hash) return false;
		
		return block.hash.substring(0, this.dificulty) == this.chain.get(0).hash.substring(0, this.dificulty);
		
	}
	
	public boolean isValidChain(Blockchain blockchain) throws NoSuchAlgorithmException {
		
		List<Block> testChain = blockchain.chain;
		List<Boolean> invalidBlocks = new ArrayList<Boolean>();
		
		for(Block bl : testChain) {
			
			boolean isSameHash = bl.hash == this.chain.get(bl.index).hash;
			boolean isSamePreviousHash = bl.previousHash == this.chain.get(bl.index).previousHash;
			
			if(!isSameHash || !isSamePreviousHash || (bl.index > 0 && !this.validadeBlock(bl, testChain.get(bl.index-1)))) invalidBlocks.add(true);
			
		}
		
		return invalidBlocks.size() == 0;
		
	}
	
	public Integer addTransactionToPending(Transaction transaction) {
		
		this.pendingTransactions.add(transaction);
		
		return this.getLatestBlock().index + 1;
		
	}
	
	public String newTransaction(Integer amount, String sender, String recipient) {
		
		Transaction transaction = new Transaction(amount, sender, recipient);
		
		return transaction.toString();
		
	}





















}
