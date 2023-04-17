/*
 * package com.bank.mailMessanger;
 * 
 * import org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.mail.javamail.MimeMessageHelper;
 * 
 * import com.bank.config.MailConfig;
 * 
 * import jakarta.mail.MessagingException; import
 * jakarta.mail.internet.MimeMessage;
 * 
 * public class MailMessenger {
 * 
 * public static void htmlEmailMessanger(String from,String toMail,String
 * subject,String body) throws MessagingException {
 * 
 * //get mail config
 * 
 * JavaMailSender sender=MailConfig.getMailConfig(); //set my message
 * 
 * MimeMessage message=sender.createMimeMessage(); MimeMessageHelper
 * htmlMessage=new MimeMessageHelper(message,true);
 * 
 * //set mail attributes /properties :
 * 
 * htmlMessage.setTo(toMail);
 * 
 * htmlMessage.setFrom(from);
 * 
 * htmlMessage.setSubject(subject);
 * 
 * htmlMessage.setText(body,true);
 * 
 * //send message sender.send(message);
 * 
 * } }
 */