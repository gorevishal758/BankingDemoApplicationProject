
package com.bank.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "v_payments")
public class PaymentHistory {

	@Id
	private int payment_id;
	private int account_id;
	private int user_id;
	private String beneficiary;
	private String beneficiary_acc_no;
	private double amount;
	private String reference_no;
	private String status;
	private String reason_code;
	private LocalDateTime created_at;

	/*
	 * @ManyToOne
	 * 
	 * @JsonIgnore private Payment payments;
	 * 
	 * @ManyToOne
	 * 
	 * @JsonIgnore private User users;
	 * 
	 * @ManyToOne
	 * 
	 * @JsonIgnore private Accounts accounts;
	 */

	public PaymentHistory() { 
		super(); // TODO Auto-generated constructor stub }
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

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

	public String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public String getBeneficiary_acc_no() {
		return beneficiary_acc_no;
	}

	public void setBeneficiary_acc_no(String beneficiary_acc_no) {
		this.beneficiary_acc_no = beneficiary_acc_no;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	/*
	 * public Payment getPayments() { return payments; }
	 * 
	 * public void setPayments(Payment payments) { this.payments = payments; }
	 * 
	 * public User getUsers() { return users; }
	 * 
	 * public void setUsers(User users) { this.users = users; }
	 * 
	 * public Accounts getAccounts() { return accounts; }
	 * 
	 * public void setAccounts(Accounts accounts) { this.accounts = accounts; }
	 */

}
