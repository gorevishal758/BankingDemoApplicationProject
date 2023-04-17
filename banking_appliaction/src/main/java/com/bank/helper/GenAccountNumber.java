package com.bank.helper;

import java.util.Random;

public class GenAccountNumber {

	public static int generatedAccountNumber() {
		
		int accountNumber;
		
		Random random=new Random();
		int bound=1000;
		
		accountNumber=bound*random.nextInt(bound);
		
		
		return accountNumber;
	}
}
