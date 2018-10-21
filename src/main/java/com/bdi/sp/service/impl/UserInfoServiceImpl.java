package com.bdi.sp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.UserInfoDAO;
import com.bdi.sp.service.UserInfoService;
import com.bdi.sp.vo.User;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO udao;
	
	@Override
	public List<User> getUserList(User ui) {
		// TODO Auto-generated method stub
		return udao.getUserList(ui);
	}

	@Override
	public User getUser(int uino) {
		// TODO Auto-generated method stub
		return udao.getUser(uino);
	}

	@Override
	public Map<String,String> insertUser(User ui) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login", "fail");
		rMap.put("msg", "다시 시도해주세요.");
		int cnt = udao.insertUser(ui);
		if(cnt==0) {
			return rMap;
		}
		if(cnt==1) {
			rMap.put("login", "success");
			rMap.put("msg", "회원가입 되셨습니다.");
		}
		return rMap;
	}

	@Override
	public int deleteUser(int uino) {
		// TODO Auto-generated method stub
		return udao.deleteUser(uino);
	}

	@Override
	public int updateUser(User ui) {
		// TODO Auto-generated method stub
		return udao.updateUser(ui);
	}

	@Override
	public Map<String,String> loginUser(User ui) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login", "fail");
		rMap.put("msg", "아이디, 비밀번호를 확인하세요");
		int cnt = udao.loginUser(ui);
		if(cnt==0) {
			return rMap;
		}
		if(cnt==1) {
			rMap.put("login", "success");
			rMap.put("msg", "로그인 되셨습니다.");
		}
		return rMap;
	}

}
