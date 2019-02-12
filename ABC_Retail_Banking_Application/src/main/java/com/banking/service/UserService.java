package com.banking.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.UserDaoF;
import com.banking.model.User;

@Service
public class UserService implements UserServiceF {

	@Autowired
	UserDaoF dao;

	public void save(User user) {
		dao.save(user);
	}

	public String findByCredential(String username, String password, String role) {
		String message = "";
		List<User> userList = (List<User>) dao.findAll();
		Iterator<User> iter = userList.iterator();
		while (iter.hasNext()) {
			User user = (User) iter.next();
			System.out.println(user.getUsername());
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())
					&& role.equals(user.getRole())) {
				message = "Welcome";
				break;
			}
		}
		if (message.equals("Welcome")) {
			return message;
		} else {
			return "Credentials are wrong";
		}
	}

	@Override
	public List<User> findAll() {
		List<User> userList = (List<User>)dao.findAll();
		return userList;
	}

	@Override
	public void deleteByAccNo(long accountNo) {
		dao.deleteByAccountNo(accountNo);
	}

	@Override
	public void updateByAccountNo(long accountNo, String username, String fname, String lname, long mobile) {
		dao.updateByAccountNo(accountNo, username, fname, lname, mobile);
	}

	@Override
	public User findByAccountNo(long accountNo) {
		return dao.findByAccountNo(accountNo);
	}
}
