package com.bank.controller_adviser;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bank.models.User;

@ControllerAdvice
public class AdviserController {

	@ModelAttribute("registerUser")
	public User getUserDefaults() {
		
		return new User();
	}
}
