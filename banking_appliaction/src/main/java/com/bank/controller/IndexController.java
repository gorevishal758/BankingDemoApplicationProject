package com.bank.controller;

import javax.management.AttributeValueExp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

import com.bank.Repo.UserRepo;
import com.bank.models.User;

import jakarta.validation.Valid;

@Controller 
public class IndexController {
	
	@Autowired
	private	UserRepo userRepo;
	
	@GetMapping("/")
	public String getIndex() {
		
//		ModelAndView getIndexPage=new ModelAndView("index");
//		getIndexPage.addObject("PageTitle","Home");
		System.out.println("In index controller");
		return "index";
	}
	
	
	
	
	@GetMapping("/error")
	public String getError() {
//		
//		ModelAndView getErrorPage=new ModelAndView("error");
//		getErrorPage.addObject("PageTitle","error");
		return "error";
	}
	
	@GetMapping("/dashboard")
	public String getDashboard( User user,Model m) {
		
//		ModelAndView getDashboardPage=new ModelAndView("dashboard");
//		getDashboardPage.addObject("PageTitle","dashboard");
		m.addAttribute("user",userRepo.findAll());
		
		return "test";
	}
	
	@GetMapping("/verify")
	public ModelAndView getVerify() {
	
		ModelAndView getVerifyPage=new ModelAndView("login");
		getVerifyPage.addObject("PageTitle","verify");
		return getVerifyPage;
	}
	

}
