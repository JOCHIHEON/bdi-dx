package com.bdi.sp.service.impl;

import java.util.List;

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
	public int insertUser(User ui) {
		// TODO Auto-generated method stub
		return udao.insertUser(ui);
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

}
