package com.bank.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Accounts {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int account_id;
	private int user_id;
	private String account_number;
	private String account_name;
	private String account_type;
	private BigDecimal balance;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;

	/*
	 * @ManyToOne
	 * 
	 * @JsonIgnore private User users;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "accounts", orphanRemoval = true) private List<Payment> payment = new
	 * ArrayList<>();
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "accounts", orphanRemoval = true) private List<Transact> transact = new
	 * ArrayList<>();
	 */

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "accounts", orphanRemoval = true) private List<PaymentHistory> paymentHistory
	 * = new ArrayList<>();
	 */

	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public List<Transact> getTransact() { return transact; }
	 * 
	 * public void setTransact(List<Transact> transact) { this.transact = transact;
	 * }
	 * 
	 * public List<Payment> getPayment() { return payment; }
	 * 
	 * public void setPayment(List<Payment> payment) { this.payment = payment; }
	 */

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	/*
	 * public User getUsers() { return users; }
	 * 
	 * public void setUsers(User users) { this.users = users; }
	 */

	/*
	 * public List<PaymentHistory> getPaymentHistory() { return paymentHistory; }
	 * 
	 * public void setPaymentHistory(List<PaymentHistory> paymentHistory) {
	 * this.paymentHistory = paymentHistory; }
	 */

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.account_id == ((Accounts) obj).getAccount_id();
	}

	

}
