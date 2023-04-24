package com.bank.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.models.PaymentHistory;
import com.bank.models.TransactionHistory;

@Repository
public interface TransactionHistoryRepo extends CrudRepository<TransactionHistory, Integer> {
 
	@Query(value = "SELECT * FROM v_transaction_history WHERE user_id= :user_id", nativeQuery = true)
	List<TransactionHistory> getTransactionRecordsById(@Param("user_id") int user_id);
}
