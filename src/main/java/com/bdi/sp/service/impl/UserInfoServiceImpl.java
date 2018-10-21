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
		return udao.getUserList(ui);
	}

	@Override
	public Map<String,String> getUser(String uiid) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("chkDupId", "success");
		rMap.put("msg", "사용 가능한 아이디 입니다.");
		if(udao.getUser(uiid)==1) {
			rMap.put("chkDupId", "fail");
			rMap.put("msg", "아이디를 사용하실 수 없습니다.");
		}
		return rMap;
	}

	@Override
	public Map<String,String> insertUser(User ui) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("join", "fail");
		rMap.put("msg", "다시 시도해주세요.");
		int cnt = udao.insertUser(ui);
		System.out.println(cnt);
		if(cnt==0) {
			return rMap;
		}
		if(cnt==1) {
			rMap.put("join", "success");
			rMap.put("msg", "회원가입 되셨습니다.");
		}
		return rMap;
	}

	@Override
	public Map<String,String> deleteUser(int uino) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("delete", "fail");
		rMap.put("msg", "삭제 실패");
		int cnt = udao.deleteUser(uino);
		if(cnt==0) {
			return rMap;
		}
		if(cnt==1) {
			rMap.put("delete", "success");
			rMap.put("msg", "삭제 완료");
		}
		return rMap;
	}

	@Override
	public Map<String,String> updateUser(User ui) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("update", "fail");
		rMap.put("msg", "수정 실패");
		int cnt = udao.updateUser(ui);
		if(cnt==0) {
			return rMap;
		}
		if(cnt==1) {
			rMap.put("update", "success");
			rMap.put("msg", "수정 완료");
		}
		return rMap;
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
