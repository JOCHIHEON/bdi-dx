package com.bdi.sp.controller;

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
	public @ResponseBody User getUser(@PathVariable int uino) {
		return us.getUser(uino);
	} 
	@RequestMapping(value="/user/chkDupId/{uiid}" ,method=RequestMethod.GET)
	public @ResponseBody Map<String, String> idDupUser(@PathVariable String uiid) {
		logger.debug("userinfo=>{}",uiid);
		return us.idDupUser(uiid);
	} 
	@RequestMapping(value="/users" ,method=RequestMethod.POST)
	public @ResponseBody Map<String,String> insertUser(@RequestBody User ui) {
		logger.debug("userinfo=>{}",ui);
		return us.insertUser(ui);
	}
	@RequestMapping(value="/users/{uino}" ,method=RequestMethod.DELETE)
	public @ResponseBody Map<String,String> deleteUser(@PathVariable Integer uino) {
		return us.deleteUser(uino);
	}
	@RequestMapping(value="/users/{uino}" ,method=RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateUser(@RequestBody User ui,@PathVariable Integer uino) {
		logger.debug("userinfo=>{}",ui);
		return us.updateUser(ui);
	}
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> login(@RequestBody User ui){
		return us.loginUser(ui);
	}

}


