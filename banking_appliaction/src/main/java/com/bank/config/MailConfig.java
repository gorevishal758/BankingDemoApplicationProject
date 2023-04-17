package com.bank.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {
	@Bean
	public static JavaMailSenderImpl getMailConfig() {
		
		JavaMailSenderImpl emailConfig=new JavaMailSenderImpl();
		
		//set properties :
		Properties props=emailConfig.getJavaMailProperties();
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.debug","true");
		
		//set mail credentials
		emailConfig.setHost("localhost");
		emailConfig.setPort(25);
		emailConfig.setUsername("no-reply@somecompany.com");
		emailConfig.setPassword("password@123");
		
		return emailConfig;
		
	}

}
