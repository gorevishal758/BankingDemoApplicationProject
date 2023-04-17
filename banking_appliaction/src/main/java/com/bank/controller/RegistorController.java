package com.bank.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.Repo.UserRepo;
import com.bank.helper.HTML;
import com.bank.helper.Message;

import com.bank.models.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class RegistorController {

	@Autowired
	private UserRepo userRepo;
	

	@GetMapping("/register")
	public String getRegister(Model m) {

		m.addAttribute("title", "register");
		m.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,
			@RequestParam("password") String password, 
			@RequestParam("confirm_password") String confirm_password,
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("email") String email, 
			
			Model m, HttpSession session) {
		try {
			if (result.hasErrors() && confirm_password.isEmpty()) {
				/* m.addAttribute("confirm_password", "The confirm field is required.."); */
				 session.setAttribute("message",new Message("Password_empty","alert-danger"));
				System.out.println("confirm_field 1..");
				return "register";

			}
			// TODO :Check for password match:

			if (!password.equals(confirm_password)) {
				System.out.println(password);
				System.out.println(confirm_password);
				
				   m.addAttribute("passwordMisMatch", "password do no match");
				 				session.setAttribute("message",new Message("passwordMisMatch","password is missmatch"));
				System.out.println("confirm_field 2..");
				return "register";
			}
			
			
			String successMessage = "Account registered successfully,please Check your email and verify account";
			User result1 = this.userRepo.save(user);
			m.addAttribute("user", new User());
			m.addAttribute("success", successMessage);
			System.out.println("confirm_field ..");
			
			session.setAttribute("message", new Message("Succesfully Register", "alert-success"));
			return "register";

		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("user", user);
			session.setAttribute("message", new Message("Something went wrong !!", "alert-danger"));
			return "register";
		}
	}

	
	

}
