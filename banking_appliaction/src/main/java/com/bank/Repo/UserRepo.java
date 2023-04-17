package com.bank.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.models.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	/*
	 * @Modifying
	 * 
	 * @Query(
	 * value="INSERT INTO users(first_name,last_name,email,password,token,code)VALUES"
	 * + "(:first_name,:last_name,:email,:password,:token,:code)",nativeQuery =
	 * true)
	 * 
	 * @Transactional void registrationUsers(@Param("first_name") String first_name,
	 * 
	 * @Param("last_name") String last_name,
	 * 
	 * @Param("email") String email,
	 * 
	 * @Param("password") String password,
	 * 
	 * @Param("token") String token,
	 * 
	 * @Param("code") String code);
	 */

	@Query(value = "select email from users  where email = :email", nativeQuery = true)
	public String getUserEmail(@Param("email") String email);
	
	@Query(value = "select * from users u where u.email = ?1", nativeQuery = true)
	public User getUserByUserName(@Param("email") String email);
	
	@Query(value = "select * from users u where u.user_id = ?1", nativeQuery = true)
	public User getUserByUserId(@Param("user_id") int user_id);
	
	@Query(value = "select * from users  where email = :email", nativeQuery = true)
	public User getUserDetails(@Param("email") String email);

	

	
	
	
	 
}
