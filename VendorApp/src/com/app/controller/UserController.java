package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
@Controller
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	//1.show userReg page
	@RequestMapping("/userReg")
	public String showPage(){
		return "UserReg";
	}

	//2.save user on click submit
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user")User user,ModelMap map){
		//generate pwd
		String pwd=codeUtil.genPwd();
		//set to user obj(Model)
		user.setPassword(pwd);
		//save using service
		int userId=service.saveUser(user);
		
		String msg="User saved with Id:"+userId;
		//also send email
		msg=msg+commonUtil.sendEmail(user.getUserEmail(), "VDM..welcomes USER", "Your userName is:email/mobile..., password is:"+pwd);
		//send message to UI
		map.addAttribute("msg",msg);
		return "UserReg";
	}
	
	
	//3.show User Login Page
	@RequestMapping("/userLogin")
	public String showLogin(){
		return "UserLogin";
	}
	
	//4. login user check
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public String checkUserLogin(
			@RequestParam("un")String un,
			@RequestParam("pwd")String pwd,
			HttpServletRequest req,
			ModelMap map
		){
		String pageName=null;
	
		User user=service.getUserByNameAndPwd(un, pwd);
		if(user==null){
			pageName="UserLogin";
			map.addAttribute("msg", "Invalid userName/password");
		}else{
			pageName="LocationReg";
			//create session
			HttpSession ses=req.getSession();
			ses.setAttribute("userName",user.getUserName());
		}
		
		return pageName;
	}
	
	//5.user logout
	@RequestMapping("/userLogout")
	public String userLogout(HttpServletRequest req,ModelMap map){
		HttpSession ses=req.getSession(false);
		ses.setAttribute("userName",null);
		ses.invalidate();
		map.addAttribute("msg", "Logout Successful...");
		return "UserLogin";
	}
	
	
	
}
