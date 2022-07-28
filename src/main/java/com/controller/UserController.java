package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;

	@GetMapping("/listusers")
	public String getAllUsers(Model model) {
		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users", users);

		return "ListUsers";

	}

	@GetMapping("/Deleteuser")
	public String deleteUser(@RequestParam("userId") int userId) {
		userDao.Deleteuser(userId);
		return "redirect:/listusers";

	}

	@GetMapping("/viewuser")
	public String viewUser(@RequestParam("userId") int userId,Model model) {
		UserBean user=userDao.getUserById(userId);
		model.addAttribute("user",user);
		return "ViewUser";
		
	}
	@GetMapping("/edituser")
	public String editUser(@RequestParam("userId") int userId,Model model) {
		UserBean user=userDao.getUserById(userId);
		model.addAttribute("user",user);
		return "EditUser";
	}
	@PostMapping("/updateuser")
	public String update(UserBean user) {
		userDao.editUser(user);
		
		return "redirect:/listusers";
	}
	

	@GetMapping("/searchusers")
	public String getUsers(@RequestParam("firstName") String firstName){
		/*
		 * List<UserBean> users=userDao.getUsers(); model.addAttribute("users",users);
		 */
		userDao.searchUserByFirstName();
		return "SearchPage";
		
	}
}
