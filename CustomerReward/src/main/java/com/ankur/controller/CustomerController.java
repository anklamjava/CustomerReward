package com.ankur.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.entity.Customer;
import com.ankur.entity.Transaction;

@RestController
public class CustomerController {

	@PostMapping("/rewards")
	public String getRewards(@RequestBody Customer customer) {

		int totalRewards = 0;

		for (Transaction transaction : customer.getTransactions()) {

			int amount = (int) transaction.getAmount();

			if (amount > 100) {
				int hundredTimes = amount - (amount - 50);
				int overHundred = (amount % 100) * 2;
				totalRewards = totalRewards + (hundredTimes + overHundred);

			}
		}

		return String.valueOf(totalRewards);
	}

}
