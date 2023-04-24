package com.bank.Repo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.models.Accounts;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepo extends CrudRepository<Accounts, Integer>{

	@Modifying
	@Query(value="INSERT INTO accounts(user_id,account_number,account_name,account_type,created_at) VALUES(:user_id,:account_number,:account_name,:account_type,:created_at)",nativeQuery = true)
	@Transactional
	void createBankAccount(@Param("user_id")int user_id,
			@Param("account_number")String account_number,
			@Param("account_name")String account_name,
			@Param("account_type")String account_type,
			@Param("created_at")LocalDateTime created_at);
	
	
	@Query(value="SELECT * FROM accounts WHERE user_id = :user_id",nativeQuery = true)
	List <Accounts> getUserAccountById(@Param("user_id")int user_id);
	
	@Query(value="SELECT sum(balance) FROM accounts WHERE user_id = :user_id",nativeQuery = true)
	BigDecimal getTotalBalance(@Param("user_id")int user_id);
	
	@Query(value="SELECT balance FROM accounts WHERE user_id = :user_id AND account_id=:account_id",nativeQuery = true)
	double getAccountBalance(@Param("user_id")int user_id,@Param("account_id") int account_id);
	
	@Modifying
	@Query(value="UPDATE accounts SET balance=:new_balance WHERE account_id=:account_id",nativeQuery = true)
	@Transactional
	void changeAccountBalanceById(@Param("new_balance") double new_balance,@Param("account_id") int account_id);
}
