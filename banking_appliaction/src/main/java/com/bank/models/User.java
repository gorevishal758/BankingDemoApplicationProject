package com.bank.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	@NotEmpty(message="first name can not be empty..")
	@Size(min=2,max=10)
	private String first_name;
	@NotEmpty
	@Size(min=2,max=10)
	private String last_name;
	
	@NotEmpty
	@Column(unique=true)
	@Email(message="Enter valid email")
	private String email;
	@NotEmpty
	@NotNull
	private String password;
	@Transient
	private String confirm_password;
	private String token;
	private int code;
	private int verified;
	private LocalDate verified_at;
	private LocalDateTime created_at ;
	private LocalDateTime updated_at ;
	private String role;
	
	
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="users",orphanRemoval = true)
	private List<Accounts> accounts=new ArrayList<>();


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirm_password() {
		return confirm_password;
	}


	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public int getVerified() {
		return verified;
	}


	public void setVerified(int verified) {
		this.verified = verified;
	}


	public LocalDate getVerified_at() {
		return verified_at;
	}


	public void setVerified_at(LocalDate verified_at) {
		this.verified_at = verified_at;
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<Accounts> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", password=" + password + ", confirm_password=" + confirm_password + ", token=" + token
				+ ", code=" + code + ", verified=" + verified + ", verified_at=" + verified_at + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", role=" + role + ", accounts=" + accounts + "]";
	}
	
	

	

}





