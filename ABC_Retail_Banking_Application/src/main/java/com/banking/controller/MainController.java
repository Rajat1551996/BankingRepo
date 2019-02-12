package com.banking.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.banking.model.User;
import com.banking.service.UserServiceF;

@RestController
public class MainController {

	@Autowired
	UserServiceF userService;

	@RequestMapping("/")
	public ModelAndView home(@ModelAttribute("accountHolder") User user) {
		return new ModelAndView("Home");
	}

	@RequestMapping("/dashboard")
	public ModelAndView login(@Valid @ModelAttribute("accountHolder") User user, BindingResult rs,
			HttpServletRequest request) {
		// if (rs.hasErrors()) {
		// return new ModelAndView("redirect:/");
		// } else {
		HttpSession session;
		// System.out.println(user.getUsername() + user.getPassword() +
		// user.getRole());
		String message = userService.findByCredential(user.getUsername(), user.getPassword(), user.getRole());
		if (message.equals("Welcome")) {
			session = request.getSession();
			session.setAttribute(user.getUsername(), "username");
			session.setAttribute(user.getRole(), "role");
			return new ModelAndView("dashboard", "message", message);
		} else {
			return new ModelAndView("Home", "message", message);
		}

		// }
	}

	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute("newAccountHolder") User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.getAttribute("username");
		session.getAttribute("role");
		return new ModelAndView("Register");
	}

	@RequestMapping("/registeration")
	public ModelAndView registeration(@Valid @ModelAttribute("newAccountHolder") User user,
			HttpServletRequest request) {
		// HttpSession session = request.getSession();
		// String username = session.getAttribute("username").toString();
		long accNo = (long) (Math.random() * 1000000000 * 10);
		user.setAccountNo(Math.round(accNo));
		// System.out.println("Account No " + user.getAccountNo());
		// System.out.println(user.getFname() + " " + user.getLname() + " " +
		// user.getMobile() + " "
		// + user.getUsername() + " " + user.getPassword() + " " +
		// user.getRole());
		userService.save(user);
		return new ModelAndView("redirect:/dashboard");
	}

	@RequestMapping("/viewAllAccounts")
	public ModelAndView viewAccounts() {
		List<User> accountList = new ArrayList();
		List<User> userList = userService.findAll();
		Iterator<User> iter = userList.iterator();
		while (iter.hasNext()) {
			User user = (User) iter.next();
			System.out.println(user.getRole());
			if (user.getRole().equalsIgnoreCase("user")) {
				accountList.add(user);
			}
		}
		// Iterator<User> iter1 = accountList.iterator();
		// while (iter1.hasNext()) {
		// System.out.println("***********" + iter1.next());
		// }
		System.out.println();
		return new ModelAndView("accounts", "userList", accountList);

	}

	@RequestMapping("/deleteAccount")
	public ModelAndView deleteAccount(@ModelAttribute("newAccountHolder") User user, HttpServletRequest request) {
		long accountNo = Integer.parseInt(request.getParameter("accountNo"));
		// System.out.println("id===========" + accountNo);
		userService.deleteByAccNo(accountNo);
		// HttpSession session = request.getSession();
		// session.getAttribute("username");
		// session.getAttribute("role");
		return new ModelAndView("redirect:/viewAllAccounts");
	}

	@RequestMapping(value = "/updateAccount")
	public ModelAndView updateAccount(@ModelAttribute("newAccountHolder") User user, HttpServletRequest request) {
		long accountNo = Integer.parseInt(request.getParameter("accountNo"));
		// String flag = request.getParameter("flag").toString();
		System.out.println("id===========" + accountNo);
		// System.out.println("flag*************" + flag);
		// userService.updateByAccNo(accountNo);
		// HttpSession session = request.getSession();
		// session.getAttribute("username");
		// session.getAttribute("role");
		user = userService.findByAccountNo(accountNo);
		List<User> accountList = new ArrayList();
		List<User> userList = userService.findAll();
		Iterator<User> iter = userList.iterator();
		while (iter.hasNext()) {
			User accountUser = (User) iter.next();
			System.out.println(accountUser.getRole());
			if (user.getRole().equalsIgnoreCase("user")) {
				accountList.add(accountUser);
			}
		}
		System.out.println();
		ModelAndView model = new ModelAndView("accounts", "userList", accountList);
		model.addObject("updatedUser", user);
		return model;
	}

	@RequestMapping(value = "/accountUpdated")
	public ModelAndView accountUpdated(@ModelAttribute("newAccountHolder") User user, HttpServletRequest request) {
		// long accountNo = Integer.parseInt(request.getParameter("accountNo"));
		// System.out.println("id===========" + accountNo);
//		userService.updateByAccountNo(user.getAccountNo(), user.getUsername(), user.getFname(), user.getLname(),
//				user.getMobile());
		System.out.println(user.getAccountNo()+ "" + user.getUsername()+""+user.getFname());
		userService.save(user);
		// List<User> accountList = new ArrayList();
		// List<User> userList = userService.findAll();
		// Iterator<User> iter = userList.iterator();
		// while (iter.hasNext()) {
		// User accountUser = (User) iter.next();
		// System.out.println(accountUser.getRole());
		// if (user.getRole().equalsIgnoreCase("user")) {
		// accountList.add(accountUser);
		// }
		// }
		// System.out.println();
		// ModelAndView model = new ModelAndView("accounts", "userList",
		// accountList);
		// model.addObject("updatedUser", user);
		return new ModelAndView("redirect:/viewAllAccounts");
	}

}
