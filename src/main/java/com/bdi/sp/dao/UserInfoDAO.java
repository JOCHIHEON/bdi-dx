package com.bdi.sp.dao;

import java.util.List;

import com.bdi.sp.vo.User;

public interface UserInfoDAO {

	public List<User> getUserList(User ui);
	public User getUser(int uino);
	public int idDupUser(String uiid);
	public int insertUser(User ui);
	public int deleteUser(int uino);
	public int updateUser(User ui);
	public int loginUser(User ui);
}
