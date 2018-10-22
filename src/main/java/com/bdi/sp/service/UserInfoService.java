package com.bdi.sp.service;

import java.util.List;
import java.util.Map;

import com.bdi.sp.vo.User;

public interface UserInfoService {

	public List<User> getUserList(User ui);
	public User getUser(User ui);
	public Map<String,String> idDupUser(String uiid);
	public Map<String,String> insertUser(User ui);
	public Map<String,String> deleteUser(int uino);
	public Map<String,String> updateUser(User ui);
	public Map<String,String> loginUser(User ui);
	
}
