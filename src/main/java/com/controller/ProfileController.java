package com.controller;

import java.net.UnknownServiceException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProfileBean;
import com.bean.SecurityQABean;
import com.bean.UserBean;
import com.dao.ProfileDao;
import com.dao.SecurityQADao;
import com.services.FileUploadService;

@Controller
public class ProfileController {
	@Autowired
	SecurityQADao securityQADao;

	@Autowired
	FileUploadService fileUploadService;

	@Autowired
	ProfileDao profileDao;

	@GetMapping("/setsquestion")
	public String setSQuestion(Model model,HttpSession session) {
		UserBean user=(UserBean) session.getAttribute("user");
		List<SecurityQABean> question = securityQADao.getAllQuestion(user.getUserId());
		model.addAttribute("question", question);
		return "SetSQuestion";
	}

	@PostMapping("/savequestion")
	public String saveQuestionAns(SecurityQABean securityQABean, HttpSession session, Model model) {

		UserBean user = (UserBean) session.getAttribute("user");
		securityQABean.setUserId(user.getUserId());
		securityQADao.addQuestion(securityQABean);

		model.addAttribute("msg", "question added");
		return "Home";
	}

	
	@GetMapping("/editquestion")
	public String editSQuestion(@RequestParam("SQuestionId") int SQuestionId, Model model) {
		SecurityQABean question = securityQADao.getQuestionById(SQuestionId);
		model.addAttribute("question", question);
		return "EditQuestion";
	}

	@PostMapping("/updatequestion")
	public String updateQuestion(SecurityQABean question) {
		securityQADao.editQuestion(question);

		return "Home";
	}

	@GetMapping("/newprofile")
	public String newProfile() {
		return "NewProfile";
	}

	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file, HttpSession session) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user.getUserId();

		fileUploadService.imgUpload(file, userId);
		ProfileBean profile = new ProfileBean();
		profile.setUserId(userId);
		profile.setImgUrl("resources\\images" +"\\"+ userId + "\\" + file.getOriginalFilename());
		profile.setActive(true);
		profileDao.addProfile(profile);

		return "NewProfile";
	}
	@GetMapping("/listallproflesimages")
	public String getAllProfileImages(HttpSession session,Model model) {
		UserBean user=(UserBean) session.getAttribute("user");
		int userId=user.getUserId();
		List<ProfileBean> profile=profileDao.getAllProfiles(userId);
		System.out.println(profile);
		model.addAttribute("profile",profile);
		
		return "ListAllImages";
		
	}

}
