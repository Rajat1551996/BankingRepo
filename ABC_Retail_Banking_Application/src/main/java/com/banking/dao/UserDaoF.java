package com.banking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.banking.model.User;

@Transactional
public interface UserDaoF extends CrudRepository<User, Integer> {

	@Modifying
	@Query(value = "delete from account_holders where account_no=:accountNo", nativeQuery = true)
	public void deleteByAccountNo(@Param("accountNo") long accountNo);

	@Modifying
	@Query(value = "update account_holders set username=:username,fname=:fname,lname=:lname,mobile=:mobile where account_no=:accountNo", nativeQuery = true)
	public void updateByAccountNo(@Param("accountNo") long accountNo, @Param("username") String username,
			@Param("fname") String fname, @Param("lname") String lname, @Param("mobile") long mobile);

	@Query(value = "select * from account_holders where account_no=:accountNo", nativeQuery = true)
	public User findByAccountNo(@Param("accountNo") long accountNo);

}
