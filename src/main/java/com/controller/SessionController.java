package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(UserBean user,Model model) {
		model.addAttribute("user",user);
		return "Signup";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid UserBean user, BindingResult result,Model model) {

		if (result.hasErrors()) {
			model.addAttribute("user",user);
			return "Signup";
		} else {
			user.setUserType("customer");
			userDao.addUser(user);
			model.addAttribute("msg","login succsessfully");
			return "Login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		return "Login";
	}

	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	public String login(@Valid LoginBean loginBean, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("somethin went wrong in login");
			return "Login";
		} else {
			System.out.println(loginBean.getEmail());
			System.out.println("successfully login");
			return "Home";
		}

	}
}
