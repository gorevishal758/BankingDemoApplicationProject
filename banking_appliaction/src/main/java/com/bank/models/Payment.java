
package com.bank.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "payments")
public class Payment {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int payment_id;

	private int account_id;

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
	 * @JsonIgnore private Accounts accounts;
	 */

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "payments", orphanRemoval = true) private List<PaymentHistory> paymentHistory
	 * = new ArrayList<>();
	 * 
	 * public List<PaymentHistory> getPaymentHistory() { return paymentHistory; }
	 * 
	 * public void setPaymentHistory(List<PaymentHistory> paymentHistory) {
	 * this.paymentHistory = paymentHistory; }
	 */

	public Payment() { 
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

	public LocalDateTime getCreate_at() {
		return created_at;
	}

	public void setCreate_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	/*
	 * public Accounts getAccounts() { return accounts; }
	 * 
	 * public void setAccounts(Accounts accounts) { this.accounts = accounts; }
	 */

	@Override public boolean equals(Object obj)
	{ // TODO Auto-generated method
  return this.payment_id == ((Payment) obj).getPayment_id(); 
  }

}
