
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
import com.bank.Repo.PaymentHistoryRepo;
import com.bank.Repo.PaymentRepo;
import com.bank.Repo.TransactionHistoryRepo;
import com.bank.Repo.UserRepo;
import com.bank.models.Accounts;
import com.bank.models.Payment;
import com.bank.models.PaymentHistory;
import com.bank.models.TransactionHistory;
import com.bank.models.User;

@Controller

@RequestMapping("/app")
public class AppController {

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PaymentRepo paymentRepo;

	@Autowired
	private PaymentHistoryRepo paymentHistoryRepo;
	
	@Autowired
	private TransactionHistoryRepo transactionHistoryRepo;

	User user;

	@GetMapping("/dashboard")
	public ModelAndView getDashboard(HttpSession session, @RequestParam(value = "email", required = false) String email,
			Model m) {

		ModelAndView getDashboardPage = new ModelAndView("dashboard");

		/* session.setAttribute("user", user); */

		// Retrieve the User object from the session
		user = (User) session.getAttribute("user");
		userRepo.getUserByUserName(email);

		m.addAttribute("user1", user);

		/* User user = userRepo.getUserByUserName(email); */
		System.out.println("users details found to be :::" + user);

		List<Accounts> getUserAccounts = accountRepo.getUserAccountById(user.getUser_id());

		System.out.println("user accounts found to be :" + getUserAccounts);

		// get balance
		BigDecimal totalAccountBalance = accountRepo.getTotalBalance(user.getUser_id());

		// set objects
		getDashboardPage.addObject("userAccounts", getUserAccounts);
		getDashboardPage.addObject("totalBalance", totalAccountBalance);

		return getDashboardPage;
	}

	@GetMapping("/payment_history")
	public ModelAndView getPaymentHistory(HttpSession session, Model m) {

		// SET VIEW
		ModelAndView getPaymentHistoryPage = new ModelAndView("paymentHistory");

		// GET USER

		user = (User) session.getAttribute("user");
		m.addAttribute("user1", user);

		// GET PAYEMNT HISTORY/RECORDS

		List<PaymentHistory> userPaymentHistory = paymentHistoryRepo.getPaymentRecordsById(user.getUser_id());

		getPaymentHistoryPage.addObject("payment_history", userPaymentHistory);

		return getPaymentHistoryPage;

	}
	@GetMapping("/transaction_history")
	public ModelAndView getTransactionHistory(HttpSession session,Model m) {
		
		ModelAndView getTransactionHistory =new ModelAndView("transactionHistory");
		
		user = (User) session.getAttribute("user");
		m.addAttribute("user1", user);
		
		List<TransactionHistory> userTransaction=transactionHistoryRepo.getTransactionRecordsById(user.getUser_id());
		
		getTransactionHistory.addObject("transaction_history", userTransaction);
		
		return getTransactionHistory;
	}

}
