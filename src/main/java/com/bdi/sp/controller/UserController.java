package com.bdi.sp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> login(@RequestBody Map<String,String> user){
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login", "fail");
		rMap.put("msg", "아이디, 비밀번호를 확인하세요");		
		if(user.get("id")==null) {
			return rMap;
		}
		if(user.get("id").equals("test")) {
			if(user.get("pwd").equals("test")) {
			rMap.put("login", "success");
			rMap.put("msg", "로그인 되셨습니다.");
			}
		}
		return rMap;
	}
}

