package com.rookie.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rookie.training.entity.Transaction;
import com.rookie.training.service.BlockchainService;

@RestController
@RequestMapping("pjchain")
public class BlockchainRestController {
	
	@Autowired
	private BlockchainService blockChainService;
	
	@GetMapping("transactions/{name}")
	public List<Transaction> getTransactionsByName(@PathVariable String name){
		
		return blockChainService.findTransactions(name);
		
	}
	
	@GetMapping("amount/{name}")
	public double getAmountByName(@PathVariable String name) {
		
		return blockChainService.findAmount(name);
		
	}
	
	@PostMapping("newTransaction")
	public void createTransaction(@RequestParam Integer amount, @RequestParam String sender, @RequestParam String recipient) {
		
		blockChainService.addTransaction(amount, sender, recipient);
		
	}

}
