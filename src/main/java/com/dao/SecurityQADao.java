package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bean.SecurityQABean;
@Repository
public class SecurityQADao {
	
	@Autowired
	JdbcTemplate stmt;

	public void addQuestion(SecurityQABean securityQABean) {
		stmt.update("insert into securityquestion (squestion,qanswer,userid) values (?,?,?)", securityQABean.getSQuestion(),
				securityQABean.getQAnswer(), securityQABean.getUserId());
	}

	public SecurityQABean getQuestionById(int sQuestionId) {
		SecurityQABean question = stmt.queryForObject("select * from securityquestion where questionid=?",
				new BeanPropertyRowMapper<SecurityQABean>(SecurityQABean.class), new Object[] { sQuestionId });
		return question;
	}
	
	public void editQuestion(SecurityQABean question) {
		stmt.update("update securityquestion set squestion=?, qanswer=? where squestionid=?", question.getSQuestion(), question.getQAnswer(),question.getSQuestionId());
	}
	
	public List<SecurityQABean> getAllQuestion(int userId) {
		return stmt.query("select * from  users inner join securityquestion on users.userid = securityquestion.userid where users.userid = ?", new BeanPropertyRowMapper<SecurityQABean>(SecurityQABean.class), new Object[] { userId });	
	}
}
