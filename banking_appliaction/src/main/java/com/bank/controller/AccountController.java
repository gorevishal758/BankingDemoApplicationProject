package com.bank.controller;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bank.Repo.AccountRepo;
import com.bank.helper.GenAccountNumber;
import com.bank.models.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepo accountRepo;
	
	LocalDateTime created_at=LocalDateTime.now();
	
	@PostMapping("/create_account")
	public String createAccount(@Valid @RequestParam("account_name")String accountName,
			@RequestParam("account_type")String accountType,
			RedirectAttributes redirectAttributes,HttpSession session) {
				
		if(accountName.isEmpty() || accountType.isEmpty() ) {
			
			redirectAttributes.addFlashAttribute("error", "Account Name and Type cannot be empty.. ");
			return "redirect:/app/dashboard";
		}
		
		//GET USER LOGGED IN
		 User user=(User)session.getAttribute("user"); 
		//GENERATE ACCOUNT NUMBER
		int setAccountNumber=GenAccountNumber.generatedAccountNumber();
		
		String bankAccountNumber=Integer.toString(setAccountNumber);
		
		//CREATE ACCOUNT 
		accountRepo.createBankAccount(user.getUser_id(), bankAccountNumber, accountName, accountType,created_at);
		
		//set success message
		redirectAttributes.addFlashAttribute("success","Account Created Successfully....");
		
		return "redirect:/app/dashboard";
	}
}
