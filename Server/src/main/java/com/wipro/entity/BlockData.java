package com.rookie.training.entity;

import java.util.List;

public class BlockData {
	
	public List<Transaction> transactions;
	public Integer number;
	
	public BlockData(Block block) {

		this.transactions = block.transactions;
		this.number = block.index;
	}

}
