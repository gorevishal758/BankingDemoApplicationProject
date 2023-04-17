
package com.bank.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;
import com.bank.Repo.AccountRepo;
import com.bank.Repo.UserRepo;
import com.bank.models.Accounts;
import com.bank.models.User;

@Controller

@RequestMapping("/app")
public class AppController {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/dashboard")
	public ModelAndView getDashboard(HttpSession session,
			@RequestParam(value = "email", required = false) String email,Model m) {

		ModelAndView getDashboardPage = new ModelAndView("dashboard");
		
		/* session.setAttribute("user", user); */
		

		
		// Retrieve the User object from the session
		User user = (User) session.getAttribute("user");
		userRepo.getUserByUserName(email);

		m.addAttribute("user1", user);
		
		/* User user = userRepo.getUserByUserName(email); */
		System.out.println("users details found to be :::" + user);
		
		 List<Accounts>getUserAccounts=accountRepo.getUserAccountById(user.getUser_id());
		 
		System.out.println("user accounts found to be :"+getUserAccounts);
		 
		 //get balance 
		 BigDecimal totalAccountBalance=accountRepo.getTotalBalance(user.getUser_id());
		 


		// set objects 
		 getDashboardPage.addObject("userAccounts", getUserAccounts);
		getDashboardPage.addObject("totalBalance", totalAccountBalance);

		return getDashboardPage;
	}
}
