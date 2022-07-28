package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		stmt.update("insert into users (firstname,lastname,email,password,usertype) values(?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUserType());
	}

	public List<UserBean> getAllUsers() {
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;

	}

	public void Deleteuser(int userId) {
		stmt.update("delete from users where userid=?", userId);
	}

	public UserBean getUserById(int userId) {

		UserBean user = stmt.queryForObject("select * from users where userid=?",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });
		return user;
	}

	public List<UserBean> getUsers() {
		List<UserBean> users = stmt.query("select * from users ", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;

	}

	public void searchUserByFirstName() {
		stmt.query("select * from users where ", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public void editUser(UserBean user) {
		stmt.update("update users set firstname=?, lastname=? where userid=?", user.getFirstName(), user.getLastName(),
				user.getUserId());
	}

	public UserBean authenticate(LoginBean login) {
		UserBean user = null;
		try {
			user = stmt.queryForObject("select * from users where email=? and password=?",
					new BeanPropertyRowMapper<UserBean>(UserBean.class),
					new Object[] { login.getEmail(), login.getPassword() });
		} catch (Exception e) {
			System.out.println("invalid email password");
		}
		return user;

	}

}
