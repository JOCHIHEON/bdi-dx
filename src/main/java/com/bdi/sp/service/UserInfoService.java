package com.bdi.sp.service;

import java.util.List;

import com.bdi.sp.vo.User;

public interface UserInfoService {

	public List<User> getUserList(User ui);
	public User getUser(int uino);
	public int insertUser(User ui);
	public int deleteUser(int uino);
	public int updateUser(User ui);
}
