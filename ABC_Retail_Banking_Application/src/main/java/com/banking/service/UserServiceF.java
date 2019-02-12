package com.banking.service;

import java.util.List;

import com.banking.model.User;

public interface UserServiceF {

	public void save(User user);

	public String findByCredential(String username, String password, String role);

	public List<User> findAll();

	public void deleteByAccNo(long accountNo);

	public void updateByAccountNo(long accountNo, String username, String fname, String lname, long mobile);

	public User findByAccountNo(long accountNo);
}
