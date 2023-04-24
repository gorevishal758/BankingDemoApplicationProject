
package com.bank.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.Repo.AccountRepo;
import com.bank.Repo.PaymentRepo;
import com.bank.Repo.TransactRepo;
import com.bank.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/transact")
public class TransactionController {

	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	private TransactRepo transactRepo;
	
	User user;
	double currentBalance;
	double newBalance;
	
	LocalDateTime currenDateTime=LocalDateTime.now();
	
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
		
		double currentBalance=accountRepo.getAccountBalance(user.getUser_id(), acc_id);
		
			
		double  newBalance=currentBalance + deposite_amountValue;
		
		//UPDATE ACCOUNT ;
		
		accountRepo.changeAccountBalanceById(newBalance, acc_id);
		
	
		//Fetch TRANSACTION HISTORY
		String reasonCode="Deposite Transaction Successfully";
		transactRepo.logTransaction(acc_id, "deposite", deposite_amountValue, "online-mode", "success", reasonCode, currenDateTime);
		
		
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
		
		//CHECK IF TRANSFER AMOUNT IS MORE THAN CURRENT AMOUNT
		if(currentBalancedOfAccountTransferringFrom <trasferAmount) {
			
			redirectAttributes.addFlashAttribute("error", "Insufficient Balance To perform this Transaction..");
			
			//LOG IN FAILD TRANSACTION HISTORY
			transactRepo.logTransaction(trasferFromId,"transfer",trasferAmount,"online","failed","insufficient balance",currenDateTime);
			
			return"redirect:/app/dashboard";
			
		}
		
		double currentBalancedOfAccountTransferringTo=accountRepo.getAccountBalance(user.getUser_id(), trasferToId);
		//SET NEW BALANCE
		double newBalancedOfAccountTransferingFrom =currentBalancedOfAccountTransferringFrom-trasferAmount;
		
		double newBalancedOfAccountTransferingTo=currentBalancedOfAccountTransferringTo + trasferAmount;
		
		//CHANGE BALANCE OF THE ACCOUNT TRANSFERING FROM
		accountRepo.changeAccountBalanceById(newBalancedOfAccountTransferingFrom, trasferFromId);
		
		//CHANGE BALANCE OF THE ACCOUNT TRANSFERING TO 
		accountRepo.changeAccountBalanceById(newBalancedOfAccountTransferingTo, trasferToId);
		
		// LOG FETCH SUCCESSFULLY TRANSACTION
		
		transactRepo.logTransaction(trasferFromId, "Transfer", trasferAmount, "online-mode", "success", "Transfer transaction successfully..", currenDateTime);
		
		redirectAttributes.addFlashAttribute("success", "Amount Transfer Succesfully!!.");
		
		return"redirect:/app/dashboard";
	}
	
	
	
	//START FOR WITHDRAW 
	@PostMapping("/withdraw")
	public String withdraw(@RequestParam("withdraw_amount")String withdraw_amount,
							@RequestParam("account_id")String account_id,
							HttpSession session,RedirectAttributes redirectAttributes) {
		
		//CHECK FOR EMPTY VALUE
		
		if( withdraw_amount.isEmpty() || account_id.isEmpty()) {
			
			redirectAttributes.addFlashAttribute("error", "withdraw amount not be empty...");
			
			return"redirect:/app/dashboard";
			
		}
		
		//CONVERT VARIABLES 
		
		
		double withdrawAmount=Double.parseDouble(withdraw_amount);
		int accountId=Integer.parseInt(account_id);
		
		//CHECK FOR ZERO
		
			if( withdrawAmount==0) {
			
					redirectAttributes.addFlashAttribute("error", "withdraw amount can not be zero...");
				
					return"redirect:/app/dashboard";
			
			}
		
		//get LoggedIN user
			user=(User)session.getAttribute("user");
			
		//CURRENT BALANCE
			
			currentBalance=accountRepo.getAccountBalance(user.getUser_id(), accountId);
			
			
			
			//CHECK IF WITHDRAW AMOUNT IS MORE THAN CURRENT AMOUNT
			if(currentBalance <withdrawAmount) {
				
				redirectAttributes.addFlashAttribute("error", "Insufficient Balance To perform this Transaction..");
				
				//LOG IN FAILD TRANSACTION HISTORY
				transactRepo.logTransaction(accountId, "Withdraw", withdrawAmount, "online-mode", "failed", "Withdraw transaction Faild..", currenDateTime);
				
				return"redirect:/app/dashboard";
				
			}
			
			
		//SET NEW BALANCE
			newBalance=currentBalance-withdrawAmount;
		//UPDATE ACCOUNT BALANCE
			accountRepo.changeAccountBalanceById(newBalance, accountId);
			
			//WITHDRAW TRASACTION FETCH
			
			transactRepo.logTransaction(accountId, "Withdraw", withdrawAmount, "online-mode", "success", "Withdraw transaction successfully..", currenDateTime);
			
			redirectAttributes.addFlashAttribute("success", "Amount Withdraw Successfully..");
		return"redirect:/app/dashboard";
	}
	
	
	//START OF PAYMENT
	@PostMapping("/payment")
	public String payment(@RequestParam("beneficiary")String beneficiary,
			@RequestParam("account_number")String account_number,
			@RequestParam("account_id")String account_id,
			@RequestParam("reference")String reference,
			@RequestParam("payment_amount")String payment_amount,
			HttpSession session,RedirectAttributes redirectAttributes) {
		
		//CHECK FOR EMPTY VALUE
		
		if(beneficiary.isEmpty() || account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()) {
			
			
			redirectAttributes.addFlashAttribute("error", " beneficiary name,account paying,account number,payment amount Can Not Be Empty..");
			return"redirect:/app/dashboard";
			
		}
		
		//CONVERT VARIABLE
		
		int accountNumber=Integer.parseInt(account_number);
		
		int accountId=Integer.parseInt(account_id);
		
		Double paymentAmount=Double.parseDouble(payment_amount);
		// CHECK FOR ZERO
		
		if(accountNumber==0 | paymentAmount==0) {
			
			redirectAttributes.addFlashAttribute("error", "Account Number and Payment Amount Can Not Be Zero..");
			return"redirect:/app/dashboard";
			
		}
		
		//GET LOGGED IN USER
		
		user=(User)session.getAttribute("user");
		
		//GET CURRENT BALANCE
		
		currentBalance=accountRepo.getAccountBalance(user.getUser_id(), accountId);
		
		
		
	
		
		
		//CHECK IF PAYEMNT AMOUNT IS MORE THAN CURRENT AMOUNT
		if(currentBalance <paymentAmount) {
			
			//LOG IN FAILD PAYMENT HISTORY
			transactRepo.logTransaction(accountId, "PAYMENT", paymentAmount, "online-mode", "failed", "Payment transaction Faild..", currenDateTime);
			
			redirectAttributes.addFlashAttribute("error", "Insufficient Balance To perform this Payement..");
			return"redirect:/app/dashboard";
			
		}
		//SET NEW BALANCE FOR ACCOUNT PAYING FROM
		
		newBalance=currentBalance-paymentAmount;
		
		
		//MAKE PAYMENT
		
		
		String reasonCode="Payment Processed Successfully";
		
				paymentRepo.makePayemnt(accountId, beneficiary, account_number, paymentAmount, reference, "Success",reasonCode,currenDateTime);
				
		
		//UPADTE ACCOUNT PAYING FROM
		
		accountRepo.changeAccountBalanceById(newBalance, accountId);
		
		
		//Payment Transaction FETCH
		
		transactRepo.logTransaction(accountId, "Payment", paymentAmount, "online-mode", "success", "Payment transaction successfully..", currenDateTime);
		
		
		redirectAttributes.addFlashAttribute("success", "Payment Processed Successfully");
		
		return"redirect:/app/dashboard";
		
	}
}
