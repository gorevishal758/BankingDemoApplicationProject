
package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.Repo.AccountRepo;
import com.bank.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/transact")
public class TransactionController {

	@Autowired
	private AccountRepo accountRepo;
	
	User user;
	double currentBalance;
	 double newBalance;
	
	
	//START OF DEPOSITE
	@PostMapping("/deposit")
	public String deposit(@RequestParam("deposite_amount") String deposite_amount,

			@RequestParam("account_id") String account_id, HttpSession session, RedirectAttributes redirectAttributes) {

		
		//TO CHECK: EMPTY STRING
		
		if(deposite_amount.isEmpty() || account_id.isEmpty()) {
			redirectAttributes.addFlashAttribute("error", "Deposite  or Amount Depositing to Can Not Be Empty");
		
			return"redirect:/app/dashboard";
		
		}
		
		//GET LOGGED IN USER
		
		user=(User)session.getAttribute("user");
		
		
		//GET CURRENT ACCOUNT BALANCE
		
		int acc_id=Integer.parseInt(account_id);
		
		double deposite_amountValue=Double.parseDouble(deposite_amount);
		
	
		
		//CHECK IF DEPOSITE AMOUNT IS 0(ZERO)
		
		if(deposite_amountValue==0) {
			redirectAttributes.addFlashAttribute("error", "Deposite Amount  Can Not Be Zero value");
			
			return"redirect:/app/dashboard";
		
		}
		//UPDATE BALANCE
		
		currentBalance=accountRepo.getAccountBalance(user.getUser_id(), acc_id);
		
		 newBalance=currentBalance + deposite_amountValue;
		
		//UPDATE ACCOUNT ;
		
		accountRepo.changeAccountBalanceById(newBalance, acc_id);
		
		redirectAttributes.addFlashAttribute("success", "Amount Deposited Successfully...");
		
		return"redirect:/app/dashboard";

	}
	
	//START OF TRANSFER
	
	@PostMapping("/transfer")
	public String transfer(@RequestParam("transfer_from") String transfer_from,
							@RequestParam("transfer_to")String transfer_to,
							@RequestParam("transfer_amount")String transfer_amount,
							HttpSession session,RedirectAttributes redirectAttributes) {
		
		//CHECK FOR EMPTY FIELD
		
		if(transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()) {
			
			redirectAttributes.addFlashAttribute("error", "Transfer From ,Transfer To and Transfer Amount can not be empty..");
			
			return"redirect:/app/dashboard";
			
		}
		//CONVERT VARIABLE
		
		int trasferFromId=Integer.parseInt(transfer_from);
		int trasferToId=Integer.parseInt(transfer_to);
		double trasferAmount=Double.parseDouble(transfer_amount);
		
		//CHECK IF TRANSFERING INTO SAME ACCOUNT
		
		if(trasferFromId ==trasferToId) {
			
				redirectAttributes.addFlashAttribute("error", "Can Not Transfer To Same Account !!.");
			
				return"redirect:/app/dashboard";
		}
		
		//CHECK FOR 0 VALUE
		if(trasferAmount ==0) {
			redirectAttributes.addFlashAttribute("error", "Transfer Amount Can Not Be zero!!.");
		
			return"redirect:/app/dashboard";
		}
		
		//GET LOGGED IN USER
		
		user=(User)session.getAttribute("user");
		
		//GET CURRENT BALANCE
		
		double currentBalancedOfAccountTransferringFrom=accountRepo.getAccountBalance(user.getUser_id(), trasferFromId);
		
		double currentBalancedOfAccountTransferringTo=accountRepo.getAccountBalance(user.getUser_id(), trasferToId);
		//SET NEW BALANCE
		double newBalancedOfAccountTransferingFrom =currentBalancedOfAccountTransferringFrom-trasferAmount;
		
		double newBalancedOfAccountTransferingTo=currentBalancedOfAccountTransferringTo + trasferAmount;
		
		//CHANGE BALANCE OF THE ACCOUNT TRANSFERING FROM
		accountRepo.changeAccountBalanceById(newBalancedOfAccountTransferingFrom, trasferFromId);
		
		//CHANGE BALANCE OF THE ACCOUNT TRANSFERING TO 
		accountRepo.changeAccountBalanceById(newBalancedOfAccountTransferingTo, trasferToId);
		
		
		redirectAttributes.addFlashAttribute("success", "Amount Transfer Succesfully!!.");
		
		return"redirect:/app/dashboard";
	}
}
