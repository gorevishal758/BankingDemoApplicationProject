package com.bank.Repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bank.models.Payment;

import jakarta.transaction.Transactional;

public interface PaymentRepo extends CrudRepository<Payment, Integer> {

	
	@Modifying
	@Query(value="INSERT INTO payments(account_id,beneficiary,beneficiary_acc_no,amount,reference_no,status,reason_code,created_at)VALUES(:account_id,:beneficiary,:beneficiary_acc_no,:amount,:reference_no,:status,:reason_code,:created_at)",nativeQuery = true)
	@Transactional
	void makePayemnt(@Param("account_id") int account_id,
			@Param("beneficiary") String beneficiary,
			@Param("beneficiary_acc_no") String beneficiary_acc_no,
			@Param("amount") Double amount,
			@Param("reference_no") String reference_no,
			@Param("status") String status,
			@Param("reason_code")String reason_code,
			@Param("created_at") LocalDateTime created_at);
}
