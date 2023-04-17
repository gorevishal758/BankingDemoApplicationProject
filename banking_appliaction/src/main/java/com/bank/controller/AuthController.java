
package com.bank.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.Repo.AccountRepo;
import com.bank.Repo.UserRepo;
import com.bank.models.Accounts;
import com.bank.models.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	 	@Autowired
	    private UserRepo userRepo;
	 	
	 	@Autowired
		private AccountRepo accountRepo;
	 	
	 	
	
	    @GetMapping("/login")
	    public String getLogin(User user) {

		// ModelAndView getLoginPage=new ModelAndView("login"); 
		//getLoginPage.addObject("PageTitle", "login");
		
		return "login";
	}
	   
	    
	    @PostMapping("/login")
	    public String signin(@RequestParam("email") String email, @RequestParam("password") String password,
	    		Model m,HttpSession session) {
	        User user = userRepo.getUserByUserName(email);
	        session.setAttribute("user", user);
	        
	        
	        //ModelAndView getDashboardPage=new ModelAndView("dashboard");
	        if (user != null && user.getPassword().equals(password)) {
	           
	        	//String getEmailInDatabase=userRepo.getUserEmail(email);
	        	
	        	m.addAttribute("user1", userRepo.getUserByUserName(email));
	        	
	        	//User user2=userRepo.getUserDetails(getEmailInDatabase);
	        	//System.out.println("users details as shown :"+user2);
	        	
	        	System.out.println("working p1   "+user);
	        	// starting of change code
				/*
				 * List<Accounts>
				 * getUserAccounts=accountRepo.getUserAccountById(user.getUser_id());
				 * 
				 * 
				 * 
				 * //get balance BigDecimal
				 * totalAccountBalance=accountRepo.getTotalBalance(user.getUser_id());
				 */
	        	
	        	// end of change code
	    		
	    		//set objects
				/*
				 * getDashboardPage.addObject("userAccounts", getUserAccounts);
				 * getDashboardPage.addObject("totalBalance", totalAccountBalance);
				 */
	        	
	        	//start of change code
				/*
				 * List<String> myList = Arrays.asList("apple", "banana", "orange");
				 * m.addAttribute("myList", myList);
				 * 
				 * m.addAttribute("userAccounts", getUserAccounts);
				 * System.out.println("user acccount"+getUserAccounts);
				 * m.addAttribute("totalBalance", totalAccountBalance);
				 */
//	        	end of change code
	        	return "redirect:/app/dashboard";
	            
	        }
	        System.out.println("working p2");
	        
	        return "login";
	    }

	
}
