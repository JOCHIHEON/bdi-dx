package com.bdi.sp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bdi.sp.service.UserInfoService;
import com.bdi.sp.vo.User;

@Controller
public class UserInfoController {

private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	private UserInfoService us;
	
	@RequestMapping(value="/users" ,method=RequestMethod.GET)
	public @ResponseBody List<User> getUserList(@ModelAttribute User ui){
		return us.getUserList(ui);
	}
	
	@RequestMapping(value="/users/{uino}" ,method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable Integer uino) {
		return us.getUser(uino);
	} 
	@RequestMapping(value="/users/{uino}" ,method=RequestMethod.POST)
	public @ResponseBody int insertUser(@ModelAttribute User ui,@PathVariable Integer uino) {
		logger.debug("userinfo=>{}",ui);
		return us.insertUser(ui);
	}
	@RequestMapping(value="/users/{uino}" ,method=RequestMethod.DELETE)
	public @ResponseBody int deleteUser(@RequestBody User ui,@PathVariable Integer uino) {
		logger.debug("userinfo=>{}",ui);
		return us.deleteUser(uino);
	}
	@RequestMapping(value="/users/{uino}" ,method=RequestMethod.PUT)
	public @ResponseBody int updateUser(@RequestBody User ui,@PathVariable Integer uino) {
		logger.debug("userinfo=>{}",ui);
		return us.updateUser(ui);
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> login(@RequestBody User user){
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login", "fail");
		rMap.put("msg", "아이디, 비밀번호를 확인하세요");
		if(us.loginUser(user)==0) {
			return rMap;
		}
		if(us.loginUser(user)==1) {
			rMap.put("login", "success");
			rMap.put("msg", "로그인 되셨습니다.");
		}
		return rMap;
	}

}


